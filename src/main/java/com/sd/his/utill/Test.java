package com.sd.his.utill;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Instant;
import java.time.temporal.ChronoField;

/*
 * @author    : irfan nasim
 * @Date      : 16-Apr-18
 * @version   : ver. 1.0.0
 * 
 * ________________________________________________________________________________________________
 *
 *  Developer				Date		     Version		Operation		Description
 * ________________________________________________________________________________________________ 
 *	
 * 
 * ________________________________________________________________________________________________
 *
 * @Project   : HIS
 * @Package   : com.sd.his.utill
 * @FileName  : Test
 *
 * Copyright © 
 * SolutionDots, 
 * All rights reserved.
 * 
 */
public class Test extends bike implements car {

    public static void main(String ...args){

     System.out.println(new BCryptPasswordEncoder().encode("Password*1"));

        Instant instant = Instant.parse( "2018-05-02T19:00:00.000Z");
        System.out.println(instant);

        System.out.println(instant.toEpochMilli());
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.get(ChronoField.MILLI_OF_SECOND));

       // long time= HISCoreUtil.convertDateToMilliSeconds(instant.toString());


    }

}

interface car{
//    default String test(){
//        System.out.println("car");
//        return null;
//    }
    String test();
}
abstract class bike{
    public String test() {
   return null;
    }
}
