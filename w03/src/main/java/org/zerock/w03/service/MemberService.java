package org.zerock.w03.service;

import org.modelmapper.ModelMapper;
import org.zerock.w03.dao.MemberDAO;
import org.zerock.w03.domain.MemberVO;
import org.zerock.w03.dto.MemberDTO;
import org.zerock.w03.util.MapperUtil;

public enum MemberService {

    INSTANCE ;

    private MemberDAO memberDAO ;
    private ModelMapper modelMapper ;

    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws  Exception {
        MemberVO vo = memberDAO.getWithPassword(mid, mpw);
        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }

    public void updateUuid(String mid, String uuid) throws  Exception {
        memberDAO.updateUuid(mid, uuid);
    }

    public MemberDTO getByUUID(String uuid) throws Exception {
        MemberVO memberVO = memberDAO.selectUUID(uuid);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);

        return memberDTO; 
    }
}
