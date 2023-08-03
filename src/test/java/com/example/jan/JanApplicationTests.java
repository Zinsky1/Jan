package com.example.jan;

import com.example.jan.model.Delegate;
import com.example.jan.unit.Type;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JanApplicationTests {



    @Test
    public void testDefaultConstructor() {
        Delegate delegate = new Delegate();

        assertEquals("USER", delegate.getUserCreate());
        assertEquals(true, delegate.getIsNowActive());
        assertEquals(LocalDateTime.now(), delegate.getDataCreateDate());
        assertNotNull(delegate.getIsNowActive());
    }

    @Test
    public void testGetterSetter() {
        Delegate delegate = new Delegate();

        delegate.setId(1L);
        assertEquals(1L, delegate.getId());

        delegate.setType(Type.REGNOM);
        assertEquals(Type.REGNOM, delegate.getType());


        delegate.setValueNameFirm("Firm Name");
        assertEquals("Firm Name", delegate.getValueNameFirm());

        delegate.setValueInsteadNameFirm("Instead Firm Name");
        assertEquals("Instead Firm Name", delegate.getValueInsteadNameFirm());

        LocalDate dtBeg = LocalDate.of(2021, 9, 1);
        delegate.setDtBeg(dtBeg);
        assertEquals(dtBeg, delegate.getDtBeg());

        LocalDate dtEnd = LocalDate.of(2021, 9, 30);
        delegate.setDtEnd(dtEnd);
        assertEquals(dtEnd, delegate.getDtEnd());

        delegate.setIsNowActive(false);
        assertFalse(delegate.getIsNowActive());

        delegate.setUserCreate("John Doe");
        assertEquals("John Doe", delegate.getUserCreate());

        LocalDateTime dataCreateDate = LocalDateTime.of(2021, 9, 15, 12, 0, 0);
        delegate.setDataCreateDate(dataCreateDate);
        assertEquals(dataCreateDate, delegate.getDataCreateDate());
    }



}
