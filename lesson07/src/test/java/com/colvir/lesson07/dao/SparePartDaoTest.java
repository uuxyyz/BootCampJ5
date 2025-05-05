package com.colvir.lesson07.dao;

import com.colvir.lesson07.model.CarType;
import com.colvir.lesson07.model.SparePart;
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
        for (CarType carType : carTypeDao.getCarTypes()) {
            // Создаём
            SparePart sparePart = new SparePart(null, carType,
                    "Шестерёнка для " + carType.getName(), 99.99F);
            
            int sparePartCount = getSparePartCount();
            SparePart savedSparePart = sparePartDao.save(sparePart);            
            Assertions.assertNotNull(savedSparePart.getId(), "ID должен быть заполенен");
            int newSparePartCount = getSparePartCount();
            Assertions.assertTrue(newSparePartCount > sparePartCount, "После добавления общее количество должно увеличиться");
            sparePart = sparePartDao.findById(savedSparePart.getId());
            Assertions.assertNotNull(sparePart, "Объект должен быть");
            
            // Обновляем
            savedSparePart.setCost(100);
            savedSparePart = sparePartDao.save(savedSparePart);
            Assertions.assertNotEquals(sparePart.getCost(), savedSparePart.getCost(), "Стоимость должна измениться");

            // Удаляем
            Assertions.assertTrue(sparePartDao.delete(sparePart.getId()) > 0);
            Assertions.assertTrue(getSparePartCount() < newSparePartCount, "После удаления общее количество должно уменьшиться");
            Assertions.assertNull(sparePartDao.findById(savedSparePart.getId()), "Объект должен отсутствовать");
        }
    }

    @Test
    public void testNoExisted() {
        final int badId = -123;
        Assertions.assertNull(sparePartDao.findById(badId), "Объект должен отсутствовать");
        SparePart sparePart = new SparePart();
        sparePart.setId(badId);
        Assertions.assertNull(sparePartDao.save(sparePart), "Объект должен отсутствовать");
    }

    private int getSparePartCount() {
        return sparePartDao.findAll().size();
    }

}
