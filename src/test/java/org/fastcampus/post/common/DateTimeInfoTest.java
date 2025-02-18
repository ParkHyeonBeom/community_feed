package org.fastcampus.post.common;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.fastcampus.post.domain.common.DateTimeInfo;
import org.junit.jupiter.api.Test;

public class DateTimeInfoTest {

    @Test
    public void givenDateTimeInfo_whenCreateContent_thenReturnFalseAndIsEdited() {

        // given, when
        DateTimeInfo dateTimeInfo = new DateTimeInfo();

        // then
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String result = LocalDateTime.now().format(formatter);
        String result2 = dateTimeInfo.getDateTime().format(formatter);

        assertEquals(result,result2);
        assertFalse(dateTimeInfo.isEdited());

    }

    @Test
    public void givenDateTimeInfo_whenUpdateContent_thenReturnTrueAndUpdateTime() {

//        // given, when
//        DateTimeInfo dateTimeInfo = new DateTimeInfo();
//        dateTimeInfo.updateEditDateTime();
//
//        // then
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//
//        String result = LocalDateTime.now().format(formatter);
//        String result2 = dateTimeInfo.getDateTime().format(formatter);
//
//        assertTrue(dateTimeInfo.isEdited());
//        assertEquals(result,result2);

        // given, when
        DateTimeInfo dateTimeInfo = new DateTimeInfo();
        LocalDateTime localDateTime = dateTimeInfo.getDateTime();

        dateTimeInfo.updateEditDateTime();

        // then

        assertTrue(dateTimeInfo.isEdited());
        assertNotEquals(localDateTime,dateTimeInfo.getDateTime());

    }

}
