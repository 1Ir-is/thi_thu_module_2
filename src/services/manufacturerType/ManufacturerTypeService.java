package services.manufacturerType;

import models.ManufacturerType;
import repositories.manufacturerType.ManufacturerTypeRepository;

import java.util.List;

public class ManufacturerTypeService implements IManufacturerTypeService {
    private final ManufacturerTypeRepository manufacturerTypeRepository = new ManufacturerTypeRepository();
    
    @Override
    public List<ManufacturerType> getAllManufacturers() {
        return manufacturerTypeRepository.findAll();
    }
    
    
}
