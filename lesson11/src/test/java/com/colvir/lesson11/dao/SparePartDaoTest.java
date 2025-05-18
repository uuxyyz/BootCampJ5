package com.colvir.lesson11.dao;

import com.colvir.lesson11.model.CarType;
import com.colvir.lesson11.model.SparePart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class SparePartDaoTest {
    @Autowired
    private SparePartDao sparePartDao;
    @Autowired
    private CarTypeDao carTypeDao;

    @Test
    public void testCrud() {
        for (CarType carType : carTypeDao.findAll()) {
            // Создаём
            SparePart sparePart = new SparePart(null, carType,
                    "Шестерёнка для " + carType.getName(), 99.99F);
            
            int sparePartCount = getSparePartCount();
            SparePart savedSparePart = sparePartDao.save(sparePart);            
            Assertions.assertNotNull(savedSparePart.getId(), "ID должен быть заполенен");
            int newSparePartCount = getSparePartCount();
            Assertions.assertTrue(newSparePartCount > sparePartCount, "После добавления общее количество должно увеличиться");
            sparePart = sparePartDao.findById(savedSparePart.getId()).get();
            Assertions.assertNotNull(sparePart, "Объект должен быть");
            
            // Обновляем
            savedSparePart.setCost(100);
            savedSparePart = sparePartDao.save(savedSparePart);
            Assertions.assertNotEquals(sparePart.getCost(), savedSparePart.getCost(), "Стоимость должна измениться");

            // Удаляем
            sparePartDao.deleteById(sparePart.getId());
            Assertions.assertTrue(getSparePartCount() < newSparePartCount, "После удаления общее количество должно уменьшиться");
            Assertions.assertFalse(sparePartDao.findById(savedSparePart.getId()).isPresent(), "Объект должен отсутствовать");
        }
    }

    @Test
    public void testNoExisted() {
        final int badId = -123;
        Assertions.assertFalse(sparePartDao.findById(badId).isPresent(), "Объект должен отсутствовать");
    }

    private int getSparePartCount() {
        return sparePartDao.findAll().size();
    }

}
