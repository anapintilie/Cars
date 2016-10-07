package cars;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarFrame extends Frame implements ActionListener {

	Frame fr;
	Label lab1, lab2, lab3, lab4, lab5, lab6;
	TextField tb1, tb2, tb3, tb4, tb5, tb6;
	Button b1, b2, b3, b4;
	String USERNAME = "grupa_1046";
	String PASSWORD = "stud";
	String CONN_STRING = "jdbc:oracle:thin:@37.120.250.20:1521:oracle";
	Connection conn;
	Statement stmt;
	ResultSet rs;
	Produs p;

	CarFrame() {

		fr = new Frame();
		fr.setLayout(null);
		fr.setVisible(true);
		fr.setSize(800, 600);

		lab1 = new Label("Marca");
		lab1.setBounds(50, 100, 100, 50);
		fr.add(lab1);

		lab2 = new Label("An Fabricare");
		lab2.setBounds(50, 150, 100, 50);
		fr.add(lab2);

		lab3 = new Label("Dotari");
		lab3.setBounds(50, 200, 100, 50);
		fr.add(lab3);

		lab4 = new Label("Pret");
		lab4.setBounds(50, 250, 100, 50);
		fr.add(lab4);

		lab5 = new Label("Combustibil");
		lab5.setBounds(50, 300, 100, 50);
		fr.add(lab5);

		lab6 = new Label("ID");
		lab6.setBounds(50, 50, 100, 50);
		fr.add(lab6);

		tb6 = new TextField();
		tb6.setBounds(150, 50, 100, 40);
		fr.add(tb6);

		tb1 = new TextField();
		tb1.setBounds(150, 100, 100, 40);
		fr.add(tb1);

		tb2 = new TextField();
		tb2.setBounds(150, 150, 100, 40);
		fr.add(tb2);

		tb3 = new TextField();
		tb3.setBounds(150, 200, 100, 40);
		fr.add(tb3);

		tb4 = new TextField();
		tb4.setBounds(150, 250, 100, 40);
		fr.add(tb4);

		tb5 = new TextField();
		tb5.setBounds(150, 300, 100, 40);
		fr.add(tb5);

		b1 = new Button("Insert");
		b1.setBounds(400, 300, 75, 50);
		fr.add(b1);
		b1.addActionListener(this);

		b2 = new Button("Update");
		b2.setBounds(500, 300, 75, 50);
		fr.add(b2);
		b2.addActionListener(this);

		b3 = new Button("Delete");
		b3.setBounds(600, 300, 75, 50);
		fr.add(b3);
		b3.addActionListener(this);

		b4 = new Button("Exit");
		b4.setBounds(700, 300, 75, 50);
		fr.add(b4);
		b4.addActionListener(this);

		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("Connected!");
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM CARDB");

		} catch (SQLException ex) {
		}

	}

	public void actionPerformed(ActionEvent ae) {
		try {

			if (ae.getSource() == b1) {

				p = new Car(Integer.parseInt(tb2.getText()), tb3.getText(), Double.parseDouble(tb4.getText()),
						tb5.getText(), tb1.getText(), Integer.parseInt(tb6.getText()), "created", "null");

				System.out.println(((Car) p).getAdaptee().toString());

				String s1 = "INSERT INTO CARDB" + " VALUES(" + ((Car) p).getAdaptee().getAnFabricare() + ",'"
						+ ((Car) p).getAdaptee().getDotari() + "'," + ((Car) p).getAdaptee().getPret() + ",'"
						+ ((Car) p).getAdaptee().getCombustibil() + "','" + ((Car) p).getAdaptee().getMarca() + "',"
						+ ((Car) p).getAdaptee().getId() + ",'" + ((Car) p).getAdaptee().getCreatedAt() + "',"
						+ ((Car) p).getAdaptee().getUpdatedAt() + ")";

				tb1.setText("");
				tb2.setText("");
				tb3.setText("");
				tb4.setText("");
				tb5.setText("");
				tb6.setText("");

				stmt.executeUpdate(s1);
				System.out.println(s1);
				rs = stmt.executeQuery("SELECT * FROM CarDB");

			} else if (ae.getSource() == b2) {
				String s2 = null;

				if (tb3.getText().length() > 2 && tb4.getText().length() > 2) {

					p = new Car(Integer.parseInt(tb6.getText()), tb3.getText(), Double.parseDouble(tb4.getText()),
							"null", "updated");
					s2 = "UPDATE CARDB SET dotari='" + ((Car) p).getAdaptee().getDotari() + "',pret="
							+ ((Car) p).getAdaptee().getPret() + ",createdAt=" + null + ",updatedAt='updated' "
							+ "WHERE ID=" + ((Car) p).getAdaptee().getId();
				} else if (tb3.getText().length() > 2) {
					p = new Car(Integer.parseInt(tb6.getText()), tb3.getText(), "null", "updated");
					s2 = "UPDATE CARDB SET dotari='" + ((Car) p).getAdaptee().getDotari() + "',createdAt=" + null
							+ ",updatedAt='updated' " + "WHERE ID=" + ((Car) p).getAdaptee().getId();
				} else if (tb4.getText().length() > 2) {
					p = new Car(Integer.parseInt(tb6.getText()), Double.parseDouble(tb4.getText()), "null", "updated");
					s2 = "UPDATE CARDB SET pret=" + ((Car) p).getAdaptee().getPret() + ",createdAt=" + null
							+ ",updatedAt='updated' " + "WHERE ID=" + ((Car) p).getAdaptee().getId();

				}

				tb1.setText("");
				tb2.setText("");
				tb3.setText("");
				tb4.setText("");
				tb5.setText("");
				tb6.setText("");
				System.out.println(s2);
				stmt.executeUpdate(s2);
				rs = stmt.executeQuery("SELECT * FROM Car");
				
			} else if (ae.getSource() == b3) {

				p = new Car(Integer.parseInt(tb6.getText()));
				String s3 = "DELETE FROM CARDB WHERE ID=" + ((Car) p).getAdaptee().getId();

				tb1.setText("");
				tb2.setText("");
				tb3.setText("");
				tb4.setText("");
				tb5.setText("");
				tb6.setText("");

				stmt.executeUpdate(s3);
				System.out.println(s3);
				rs = stmt.executeQuery("SELECT * FROM Car");

			} else if (ae.getSource() == b4) {

				conn.commit();
				conn.close();
				System.exit(0);

			}

		} catch (

		Exception e) {
		}

	}
}