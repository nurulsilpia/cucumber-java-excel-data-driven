package stepDef;

import datatables.ExcelConfiguration;
import datatables.ExcelDataReader;
import datatables.IDataReader;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class TestExcel_steps {
    @Given("The excel file name and location is given as")
    public void theExcelFileNameAndLocationIsGivenAs(IDataReader dataTable) {
        System.out.println(dataTable.getAllRows());

        List<Map<String, String>> data = dataTable.getAllRows();
        System.out.println(data.get(3).get("email"));
    }

    // 1. create a another method
    // 2. Parameter to the method will be a map object
    // 3. IdataReader will be return type
    // 4. @DataTableType

    @DataTableType
    public IDataReader excelToDataTable(Map<String, String> entry) { // [Excel= <fileName>, Location=<FileLocation> ..]
        ExcelConfiguration config = new ExcelConfiguration.ExcelConfigurationBuilder()
                .setFileName(entry.get("Excel"))
                .setFileLocation(entry.get("Location"))
                .setSheetName(entry.get("Sheet"))
                .setIndex(Integer.valueOf(entry.getOrDefault("Index", "0")))
                .build();
        return new ExcelDataReader(config);

    }
}
