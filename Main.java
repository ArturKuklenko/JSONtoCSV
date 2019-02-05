package new5;

import com.fasterxml.jackson.databind.ObjectMapper;

import New.SimpleInterface;
import New2.SimpleInterfaceFX;
import javafx.application.Application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class Main {
	/*
	 * In main method now we create SimpleInterface only.
	 * */
public static void main(String[] args) throws IOException {
	new SimpleInterface();
}
/*
 * The method that was main before,
 * now the User Interface starts to execute it after button convert was cliked
 * */
public static void execute(String JSONpath, String CSVpath) {
	// Open the file
	FileInputStream fileInputStream = new FileInputStream(JSONpath);
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

	String jsnLn;
	ObjectMapper objectMapper = new ObjectMapper();

	List<Persons> personsList = new ArrayList<Persons>();
	List<Cars> carsList = new ArrayList<Cars>();
	List<Electronics> electronicsList = new ArrayList<Electronics>();
	List<Houses> housesList = new ArrayList<Houses>();
	int personsIndex = 0;
	StringBuilder rowbuilder = new StringBuilder();
	//Read File Line By Line
	while ((jsnLn = bufferedReader.readLine()) != null) {
	if (jsnLn.contains("persons")) {
	Persons persons = objectMapper.readValue(jsnLn, Persons.class);
	try {
	builder.append(personsList.get(personsIndex).getName()+";");
	builder.append(personsList.get(personsIndex).getAge()+";");
	builder.append(personsList.get(personsIndex).getEyeColor()+";");
	builder.append(personsList.get(personsIndex).getFamilyData().get(0).getFatherName()+";");
	builder.append(personsList.get(personsIndex).getFamilyData().get(1).getMotherName()+";");
	}
	catch (Exception e1) {
	e1.printStackTrace();
	}
	personsIndex++;
	}

	if (jsnLn.contains("cars")) {
	Cars cars = objectMapper.readValue(jsnLn, Cars.class);
	try {
	builder.append(carsList.get(0).getBrand()+";");
	builder.append(carsList.get(0).getModel()+";");
	builder.append(carsList.get(0).getColor()+";");
	builder.append(carsList.get(0).getHistoryData().get(0).getFirstRegistration()+";");
	builder.append(carsList.get(0).getEngineData(0).get(1).getMaxTorque()+";");
	}
	catch (Exception e1) {
	e1.printStackTrace();
	}
	}
	if (jsnLn.contains("electronics")) {
	Electronics electronics = objectMapper.readValue(jsnLn, Electronics.class);
	try {
	builder.append(electronicsList.get(0).getSmartphoneBrand()+";");
	builder.append(electronicsList.get(0).getSmartphoneModel()+";");
	builder.append(electronicsList.get(0).getSmartphoneColor()+";");
	builder.append(electronicsList.get(0).getSmartPhoneTechData().get(0).getProcessor()+";");
	builder.append(electronicsList.get(0).getHistoryData().get(1).getFactory()+";");
	}
	catch (Exception e1) {
	e1.printStackTrace();
	}
	}
	}
	//Close the input stream
	bufferedReader.close();
	StringBuilder ColumnBuilder = new StringBuilder();
	ColumnBuilder.append("Person Name");
	ColumnBuilder.append("Person Age");
	ColumnBuilder.append("Person Father Name");
	ColumnBuilder.append("Person Mother Name");
	ColumnBuilder.append("Car Brand");
	ColumnBuilder.append("Car Model");
	ColumnBuilder.append("Car Color");
	ColumnBuilder.append("Car First Registration");
	ColumnBuilder.append("Car Max Torque");

	PrintWriter printwrite = null;
	try {
	printwriter = new PrintWriter(new File(CSVpath));
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}

	StringBuilder columnbuilder = new StringBuilder();
	String ColumnNamesList = ColumnBuilder.toString();
	columnbuilder.append(ColumnNamesList+"\n");
	printwrite.write(columnbuilder.toString());
	printwrite.write(rowbuilder.toString());
	printwrite.close();
	System.out.println("DONE!");
}
}
