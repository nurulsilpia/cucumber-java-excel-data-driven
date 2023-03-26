@DataDriven
Feature: Read the data from external filesystem and transform it
  Scenario: Convert data table to the user define type
    Given The excel file name and location is given as
      | Excel              | Location                    | Sheet  | Index |
      | ExcelDataTest.xlsx | FileData/ExcelDataTest.xlsx | Sheet1 | 3     |
