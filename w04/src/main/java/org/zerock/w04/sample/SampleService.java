package org.zerock.w04.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@ToString
@Service
@RequiredArgsConstructor
public class SampleService {

/*
    @Autowired
    private final SampleDAO sampleDAO ;
*/

    @Qualifier("normal")
    private final SampleDAO sampleDAO;

}
