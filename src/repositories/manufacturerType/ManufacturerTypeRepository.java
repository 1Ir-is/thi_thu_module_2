package repositories.manufacturerType;

import models.ManufacturerType;
import utils.SaveFileUtils;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerTypeRepository implements IManufacturerTypeRepository {
    private static final String MANUFACTURER_TYPE_FILE = "src/datas/hangCheTao.csv";
    
    @Override
    public List<ManufacturerType> findAll() {
        List<String> lines = SaveFileUtils.readFromFile(MANUFACTURER_TYPE_FILE);
        List<ManufacturerType> manufacturerTypeList = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(",\\s*");
            if (parts.length == 3) {
                manufacturerTypeList.add(new ManufacturerType(parts[0], parts[1], parts[2]));
            }
        }
        return manufacturerTypeList;
    }
}
