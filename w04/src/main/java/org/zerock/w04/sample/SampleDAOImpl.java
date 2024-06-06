package org.zerock.w04.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("event")
public class SampleDAOImpl implements SampleDAO{
}
