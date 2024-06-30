package org.zerock.w08.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.w08.dto.upload.UploadFileDTO;
import org.zerock.w08.dto.upload.UploadResultDTO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Handler;

@RestController
@Log4j2
public class UpDownController {

    @Value("${org.zerock.upload.path}")
    private String uploadPath;

//    @Operation(summary = "upload post", description = "Post 파일 등록")
//    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String upload(@Valid @Parameter(content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE) ) UploadFileDTO uploadFileDTO){
//        log.info(uploadFileDTO);
//
//        if(uploadFileDTO.getFiles() != null){
//
//
//            uploadFileDTO.getFiles().forEach(multipartFile -> {
//                String originalName = multipartFile.getOriginalFilename();
//                log.info(originalName);
//                log.info("**********");
//                String uuid = UUID.randomUUID().toString();
//                Path savePath = Paths.get(uploadPath, uuid + "_" +originalName);
//
//                try {
//                    multipartFile.transferTo(savePath);
//
//                    if(Files.probeContentType(savePath).startsWith("image")){
//                        File thumbFile = new File(uploadPath, "s_" + uuid + "_"+originalName);
//
//                        Thumbnailator.createThumbnail(savePath.toFile(), thumbFile, 200, 200);
//                    }
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//                log.info(multipartFile.getOriginalFilename());
//            });
//        }
//        return null;
//    }


    @Operation(summary = "upload post", description = "Post 파일 등록")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<UploadResultDTO> upload(@Valid @Parameter(content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE) ) UploadFileDTO uploadFileDTO){
        log.info(uploadFileDTO);

        if(uploadFileDTO.getFiles() != null){

            final List<UploadResultDTO> list = new ArrayList<>();

            uploadFileDTO.getFiles().forEach(multipartFile -> {
                String originalName = multipartFile.getOriginalFilename();
                log.info(originalName);
                String uuid = UUID.randomUUID().toString();
                Path savePath = Paths.get(uploadPath, uuid + "_" +originalName);

                boolean image = false;
                try {
                    multipartFile.transferTo(savePath);

                    if(Files.probeContentType(savePath).startsWith("image")){
                        image = true;
                        File thumbFile = new File(uploadPath, "s_" + uuid + "_"+originalName);

                        Thumbnailator.createThumbnail(savePath.toFile(), thumbFile, 200, 200);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
                log.info(multipartFile.getOriginalFilename());

                list.add(UploadResultDTO.builder()
                        .uuid(uuid)
                        .fileName(originalName)
                        .img(image).build());
            });

            return list;
        }
        return null;
    }

    @Operation(summary = "view File", description = "GET 방식 파일 조화")
    @GetMapping("/view/{fileName}")
    public ResponseEntity<FileSystemResource> viewFileGet(@PathVariable String fileName){
        FileSystemResource resource = new FileSystemResource(uploadPath + File.separator + fileName);

        String resourceName = resource.getFilename();
        HttpHeaders headers = new HttpHeaders();

        try {
            headers.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    @Operation(summary = "delete File", description = "DELETE 방식으로 파일삭제")
    @DeleteMapping("/remove/{fileName}")
    public Map<String, Boolean> removeFile(@PathVariable String fileName){

        Resource resource = new FileSystemResource(uploadPath+ File.separator + fileName);

        String resourceName = resource.getFilename();

        Map<String, Boolean> resultMap = new HashMap<>();

        boolean removed = false;
        try {
            String contentType = Files.probeContentType(resource.getFile().toPath());
            removed = resource.getFile().delete();

            if (contentType.startsWith("image")){
                File thumbnailFile = new File(uploadPath + File.separator + "s_" + fileName);

                thumbnailFile.delete();
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }

        resultMap.put("result", removed);

        return resultMap;
    }


}
