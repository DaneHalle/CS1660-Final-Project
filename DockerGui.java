import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class DockerGui {

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndRunGUI();
			}
		});
	}

	public static void createAndRunGUI(){
		int x = 400, y = 400;


		JFrame frame = new JFrame("Data Science Toolbox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(x,y); 

		JButton RStudio = new JButton("RStudio");
		RStudio.addActionListener(new rstudio());
		JButton Sypder = new JButton("Sypder");
		Sypder.addActionListener(new sypder());
		JButton IBMSAS = new JButton("IBMSAS");
		IBMSAS.addActionListener(new ibmsas());
		JButton Git = new JButton("Git");
		Git.addActionListener(new git());
		JButton Jupyter = new JButton("Jupyter");
		Jupyter.addActionListener(new jupyter());
		JButton Orange = new JButton("Orange");
		Orange.addActionListener(new orange());
		JButton VSCodeide = new JButton("VSCodeide");
		VSCodeide.addActionListener(new vscodeide());
		JButton Hadoop = new JButton("Hadoop");
		Hadoop.addActionListener(new hadoop());
		JButton Spark = new JButton("Spark");
		Spark.addActionListener(new spark());
		JButton Tableau = new JButton("Tableau");
		Tableau.addActionListener(new tableau());
		JButton SonarCloud = new JButton("SonarCloud");
		SonarCloud.addActionListener(new sonarcloud());
		JButton Tensorflow = new JButton("Tensorflow");
		Tensorflow.addActionListener(new tensorflow());
		JButton Markdown = new JButton("Markdown");
		Markdown.addActionListener(new markdown());


		JPanel action_panel = new JPanel(new GridLayout(13,1));

		action_panel.add(RStudio);
		action_panel.add(Sypder);
		action_panel.add(IBMSAS);
		action_panel.add(Git);
		action_panel.add(Jupyter);
		action_panel.add(Orange);
		action_panel.add(VSCodeide);
		action_panel.add(Hadoop);
		action_panel.add(Spark);
		action_panel.add(Tableau);
		action_panel.add(SonarCloud);
		action_panel.add(Tensorflow);
		action_panel.add(Markdown);


		frame.add(action_panel, BorderLayout.CENTER);

		frame.setVisible(true);
	}

	static class rstudio implements ActionListener{
		public rstudio() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open RStuido
			System.out.println("Pressed: rstudio");
		}
	}

	static class sypder implements ActionListener{
		public sypder() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open Sypder
			System.out.println("Pressed: sypder");
		}
	}

	static class ibmsas implements ActionListener{
		public ibmsas() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open IBM SAS
			System.out.println("Pressed: ibmsas");
		}
	}

	static class git implements ActionListener{
		public git() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open Git
			System.out.println("Pressed: git");
		}
	}

	static class jupyter implements ActionListener{
		public jupyter() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open Jupyter Notebook
			System.out.println("Pressed: jupyter");
		}
	}

	static class orange implements ActionListener{
		public orange() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open Orange
			System.out.println("Pressed: orange");
		}
	}

	static class vscodeide implements ActionListener{
		public vscodeide() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open Visual Studio Code IDE
			System.out.println("Pressed: vscodeide");
		}
	}

	static class hadoop implements ActionListener{
		public hadoop() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open Apache Hadoop
			System.out.println("Pressed: hadoop");
		}
	}

	static class spark implements ActionListener{
		public spark() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open Apache Spark
			System.out.println("Pressed: spark");
		}
	}

	static class tableau implements ActionListener{
		public tableau() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open Tableau
			System.out.println("Pressed: tableau");
		}
	}

	static class sonarcloud implements ActionListener{
		public sonarcloud() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open SonarCloud
			System.out.println("Pressed: sonarcloud");
		}
	}

	static class tensorflow implements ActionListener{
		public tensorflow() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open Tensorflow
			System.out.println("Pressed: tensorflow");
		}
	}

	static class markdown implements ActionListener{
		public markdown() {

		}

		public void actionPerformed(ActionEvent ev) {
			// Open nano markdown
			System.out.println("Pressed: markdown");
		}
	}
}
