package com.pojoclasses;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Data{
    @JsonProperty("color") 
    public String getColor() { 
		 return this.color; } 
    public void setColor(String color) { 
		 this.color = color; } 
    String color;
    @JsonProperty("capacity") 
    public String getCapacity() { 
		 return this.capacity; } 
    public void setCapacity(String capacity) { 
		 this.capacity = capacity; } 
    String capacity;
    @JsonProperty("capacity GB") 
    public int getCapacityGB() { 
		 return this.capacityGB; } 
    public void setCapacityGB(int capacityGB) { 
		 this.capacityGB = capacityGB; } 
    int capacityGB;
    @JsonProperty("price") 
    public double getPrice() { 
		 return this.price; } 
    public void setPrice(double price) { 
		 this.price = price; } 
    double price;
    @JsonProperty("generation") 
    public String getGeneration() { 
		 return this.generation; } 
    public void setGeneration(String generation) { 
		 this.generation = generation; } 
    String generation;
    @JsonProperty("year") 
    public int getYear() { 
		 return this.year; } 
    public void setYear(int year) { 
		 this.year = year; } 
    int year;
    @JsonProperty("CPU model") 
    public String getCPUModel() { 
		 return this.cPUModel; } 
    public void setCPUModel(String cPUModel) { 
		 this.cPUModel = cPUModel; } 
    String cPUModel;
    @JsonProperty("Hard disk size") 
    public String getHardDiskSize() { 
		 return this.hardDiskSize; } 
    public void setHardDiskSize(String hardDiskSize) { 
		 this.hardDiskSize = hardDiskSize; } 
    String hardDiskSize;
    @JsonProperty("Strap Colour") 
    public String getStrapColour() { 
		 return this.strapColour; } 
    public void setStrapColour(String strapColour) { 
		 this.strapColour = strapColour; } 
    String strapColour;
    @JsonProperty("Case Size") 
    public String getCaseSize() { 
		 return this.caseSize; } 
    public void setCaseSize(String caseSize) { 
		 this.caseSize = caseSize; } 
    String caseSize;
  
    @JsonProperty("Description") 
    public String getDescription() { 
		 return this.description; } 
    public void setDescription(String description) { 
		 this.description = description; } 
    String description;
    
    @JsonProperty("Color") 
    public String getColor1() { 
		 return this.color; } 
    public void setColor1(String color) { 
		 this.color = color; } 
    String color1;
    
    @JsonProperty("Capacity") 
    public String getCapacity1() { 
		 return this.capacity1; } 
    public void setCapacity1(String capacity1) { 
		 this.capacity1 = capacity1; } 
    String capacity1;
    
    @JsonProperty("Screen size") 
    public double getScreenSize() { 
		 return this.screenSize1; } 
    public void setScreenSize(double screenSize1) { 
		 this.screenSize1 = screenSize1; } 
    double screenSize1;
    @JsonProperty("Generation") 
    public String getGeneration1() { 
		 return this.generation1; } 
    public void setGeneration1(String generation1) { 
		 this.generation1 = generation1; } 
    String generation1;
    @JsonProperty("Price") 
    public String getPrice1() { 
		 return this.price1; } 
    public void setPrice1(String price1) { 
		 this.price1 = price1; } 
    String price1;
   
}