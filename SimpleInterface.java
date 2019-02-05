package new5;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class SimpleInterface implements ActionListener {
	JPanel panel;
	JFrame frame;
	JButton convert;
	JButton browse1;
	JButton browse2;
	JTextField jsonFilePath;
	JTextField csvFilePath;
	JLabel JSONpath;
	JLabel CSVpath;
	JFileChooser fileopen;
	/*
	 * Above All components we needed, all from Java Swing library
	 * Below constructor, it create User Interface
	 * */
	public SimpleInterface() {
		frame = new JFrame("JSON convert to CSV");
		frame.setSize(450,300);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		convert = new JButton("Convert to CSV");
		browse1 = new JButton("Browse");
		browse2 = new JButton("Browse");
		jsonFilePath = new JTextField(20);
		csvFilePath = new JTextField(20);
		csvFilePath.setText("C:/");

		JSONpath = new JLabel("JSON file path:");
		CSVpath = new JLabel("CSV file path:");
		

		JSONpath.setBounds(10,20,150,20);
		CSVpath.setBounds(10,80,80,20);
		jsonFilePath.setBounds(100,20,200,20);
		csvFilePath.setBounds(100,80,200,20);
		browse1.setBounds(305,20,100,20);
		browse2.setBounds(305,80,100,20);

		convert.setBounds(160,200,130,30);
			
		convert.addActionListener(this);
		browse1.addActionListener(this);
		browse2.addActionListener(this);
		frame.add(panel);
		panel.add(convert);
		panel.add(browse1);
		panel.add(browse2);
		panel.add(JSONpath);
		panel.add(CSVpath);
		panel.add(jsonFilePath);
		panel.add(csvFilePath);

		frame.setLocation(300, 300);
		frame.setVisible(true);
	}
	/*
	 * All logic located in ActionPerformed method
	 * At first create new button from source we got,
	 * it is like make copy of button that was cliked.
	 * Than in "if" statement we understand which button was cliked.
	 * And perform proper action, open file chooser or execute
	 * method from Main class, another words start to converting. 
	 * 
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton theButton = (JButton) e.getSource();
		if(theButton==browse1){
		fileopen = new JFileChooser();
		fileopen.setCurrentDirectory(new File("C:/"));
		int ret = fileopen.showDialog(null, "Open File");
		if (ret == JFileChooser.APPROVE_OPTION) {
		    File file = fileopen.getSelectedFile();
		    String tmp = file.getParent()+"\\"+file.getName();
		    String tmp_2 = tmp.replace("\\","/");
		    jsonFilePath.setText(tmp_2);
		}
		}
		if(theButton==browse2){
			fileopen = new JFileChooser();
			fileopen.setCurrentDirectory(new File("C:/"));
			int ret = fileopen.showDialog(null, "Open File");
			if (ret == JFileChooser.APPROVE_OPTION) {
			    File file = fileopen.getSelectedFile();
			    String tmp = file.getParent()+"\\"+file.getName();
			    String tmp_3 = tmp.replace("\\","/");
			    csvFilePath.setText(tmp_3);
		}
		}
		if(theButton==convert){
			Main.execute(jsonFilePath.getText(), csvFilePath.getText());
		}
		
	}

}
