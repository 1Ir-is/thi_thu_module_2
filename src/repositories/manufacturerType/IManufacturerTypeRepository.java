package repositories.manufacturerType;

import models.ManufacturerType;

import java.util.List;

public interface IManufacturerTypeRepository {
    List<ManufacturerType> findAll();
}
