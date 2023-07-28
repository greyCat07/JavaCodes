import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SalesmanDB {

	private JFrame frame;
	private JTable table;
	private JTextField txtSNumber;
	private JTextField txtSName;
	private JLabel lblNewLabel_1;
	private JTextField txt1QS;
	private JLabel lblNewLabel_2;
	private JTextField txt2QS;
	private JLabel lblNewLabel_3;
	private JTextField txt3QS;
	private JLabel lblNewLabel_4;
	private JTextField txt4QS;
	private JLabel lblNewLabel_5;
	private JButton btnSave;
	private JButton btnClear;
	private JButton btnPrint;
	private JPanel panel_1;
	private JTextField txtSearchNumber;
	private JLabel lblNewLabel_6;
	private JPanel panel_2;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnExit;
	private JScrollPane scrollPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesmanDB window = new SalesmanDB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SalesmanDB() {
		initialize();
		Connect();
		table_load();
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JButton btnSearch;

	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/SALESMANdatabase", "root", "");
			JOptionPane.showMessageDialog(null, "Connection Made");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Error");
		}
	}

	public void table_load() {
		try {
			pst = con.prepareStatement("select * from salesman");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1200, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 27, 775, 526);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Salesman Number", "Salesman Name", "1st Quarter Sale", "2nd Quarter Sale", "3rd Quarter",
						"Sale", "4th Quarter Sale", "Total Sales", "Commission"
				}));

		table.getColumnModel().getColumn(0).setPreferredWidth(97);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
		table.getColumnModel().getColumn(6).setPreferredWidth(95);
		table.getColumnModel().getColumn(7).setPreferredWidth(95);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Salesman Database System",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 379, 352);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Salesman Number:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 34, 112, 17);
		panel.add(lblNewLabel);

		txtSNumber = new JTextField();
		txtSNumber.setBounds(132, 31, 215, 20);
		panel.add(txtSNumber);
		txtSNumber.setColumns(10);

		txtSName = new JTextField();
		txtSName.setColumns(10);
		txtSName.setBounds(132, 72, 215, 20);
		panel.add(txtSName);

		lblNewLabel_1 = new JLabel("Salesman Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 75, 112, 17);
		panel.add(lblNewLabel_1);

		txt1QS = new JTextField();
		txt1QS.setColumns(10);
		txt1QS.setBounds(132, 109, 215, 20);
		panel.add(txt1QS);

		lblNewLabel_2 = new JLabel("1st Quarter Sale:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 112, 112, 17);
		panel.add(lblNewLabel_2);

		txt2QS = new JTextField();
		txt2QS.setColumns(10);
		txt2QS.setBounds(132, 151, 215, 20);
		panel.add(txt2QS);

		lblNewLabel_3 = new JLabel("2nd Quarter Sale:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 154, 112, 17);
		panel.add(lblNewLabel_3);

		txt3QS = new JTextField();
		txt3QS.setColumns(10);
		txt3QS.setBounds(132, 197, 215, 20);
		panel.add(txt3QS);

		lblNewLabel_4 = new JLabel("3rd Quarter Sale:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 200, 112, 17);
		panel.add(lblNewLabel_4);

		txt4QS = new JTextField();
		txt4QS.setColumns(10);
		txt4QS.setBounds(132, 244, 215, 20);
		panel.add(txt4QS);

		lblNewLabel_5 = new JLabel("4th Quarter Sale:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 247, 112, 17);
		panel.add(lblNewLabel_5);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SalesmanName;
				float q1, q2, q3, q4, commission;
				double total_sales;
				int SalesmanNumber = Integer.parseInt(txtSNumber.getText());
				SalesmanName = txtSName.getText();
				q1 = Float.parseFloat(txt1QS.getText());
				q2 = Float.parseFloat(txt2QS.getText());
				q3 = Float.parseFloat(txt3QS.getText());
				q4 = Float.parseFloat(txt4QS.getText());
				total_sales = q1 + q2 + q3 + q4;
				if (total_sales <= 5000) {
					commission = (float) (total_sales * 0.1);
				} else if (total_sales <= 10000) {
					commission = (float) (total_sales * 0.15);
				} else if (total_sales <= 15000) {
					commission = (float) (total_sales * 0.2);
				} else if (total_sales <= 20000) {
					commission = (float) (total_sales * 0.25);
				} else
					commission = (float) (total_sales * 0.35);
				try {
					pst = con.prepareStatement(
							"INSERT INTO salesmandata(SalesmanNumber, SalesmanName, 1stQuarterlySales, 2ndQuarterlySales, 3rdQuarterlySales, 4thQuarterlySales, TotalSales, Commission)values(?,?,?,?,?,?,?,?)");
					pst.setInt(1, SalesmanNumber);
					pst.setString(2, SalesmanName);
					pst.setFloat(3, q1);
					pst.setFloat(4, q2);
					pst.setFloat(5, q3);
					pst.setFloat(6, q4);
					pst.setDouble(7, total_sales);
					pst.setFloat(8, commission);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added.");
					table_load();

					txtSNumber.setText("");
					txtSName.setText("");
					txt1QS.setText("");
					txt2QS.setText("");
					txt3QS.setText("");
					txt4QS.setText("");
					txtSName.requestFocus();
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setBounds(21, 294, 89, 23);
		panel.add(btnSave);

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSNumber.setText("");
				txtSName.setText("");
				txt1QS.setText("");
				txt2QS.setText("");
				txt3QS.setText("");
				txt4QS.setText("");
			}
		});
		btnClear.setBounds(141, 294, 89, 23);
		panel.add(btnClear);

		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Printing in Progress");
				MessageFormat footer = new MessageFormat("Page {0, number, integer}");
				try {
					table.print();
				} catch (java.awt.print.PrinterException ev) {
					System.err.format("No Printer found", ev.getMessage());
				}
			}
		});

		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPrint.setBounds(258, 295, 89, 23);
		panel.add(btnPrint);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 397, 379, 93);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		txtSearchNumber = new JTextField();
		txtSearchNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		txtSearchNumber.setColumns(10);
		txtSearchNumber.setBounds(132, 33, 215, 20);
		panel_1.add(txtSearchNumber);

		lblNewLabel_6 = new JLabel("Salesman Number");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 36, 112, 17);
		panel_1.add(lblNewLabel_6);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int SalesmanNumber = Integer.parseInt(txtSearchNumber.getText());
					pst = con.prepareStatement(
							"select SalesmanNumber, SalesmanName,FirstQuarter,SecondQuarter,ThirdQuarter,FourtQuarter,Total_Sales,Commission from salesman where Salesman_Number = ?");
					pst.setInt(1, SalesmanNumber);
					ResultSet rs = pst.executeQuery();

					if (rs.next() == true) {
						int SalesmanNum = rs.getInt(1);
						String SalesmanName = rs.getString(2);
						float FirstQuarter = rs.getFloat(3);
						float SecondQuarter = rs.getFloat(4);
						float ThirdQuarter = rs.getFloat(5);
						float FourtQuarter = rs.getFloat(6);

						String SNum = String.valueOf(SalesmanNum);
						String q1 = String.valueOf(FirstQuarter);
						String q2 = String.valueOf(SecondQuarter);
						String q3 = String.valueOf(ThirdQuarter);
						String q4 = String.valueOf(FourtQuarter);

						txtSNumber.setText(SNum);
						txtSName.setText(SalesmanName);
						txt1QS.setText(q1);
						txt2QS.setText(q2);
						txt3QS.setText(q3);
						txt4QS.setText(q4);

					} else {
						JOptionPane.showMessageDialog(null, "Record not exists!");

					}
				} catch (SQLException ex) {
				}
			}
		});

		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(20, 59, 89, 23);
		panel_1.add(btnSearch);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(20, 376, 355, 10);
		frame.getContentPane().add(panel_2);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SalesmanName;
				float q1, q2, q3, q4, commission;
				double totalsales;

				int SalesmanNumber = Integer.parseInt(txtSearchNumber.getText());
				SalesmanName = txtSName.getText();
				q1 = Float.parseFloat(txt1QS.getText());
				q2 = Float.parseFloat(txt2QS.getText());
				q3 = Float.parseFloat(txt3QS.getText());
				q4 = Float.parseFloat(txt4QS.getText());

				totalsales = q1 + q2 + q3 + q4;
				if (totalsales <= 5000) {
					commission = (float) (totalsales * 0.1);
				} else if (totalsales <= 10000) {
					commission = (float) (totalsales * 0.15);
				} else if (totalsales <= 15000) {
					commission = (float) (totalsales * 0.2);
				} else if (totalsales <= 20000) {
					commission = (float) (totalsales * 0.25);
				} else
					commission = (float) (totalsales * 0.35);

				try {
					pst = con.prepareStatement(
							"update salesman set Salesman_Name= ?,FirstQuarter=?,SecondQuarter=?,ThirdQuarter=?,FourtQuarter=?,Total_Sales=?,Commission=? where Salesman_Number =?");
					pst.setString(1, SalesmanName);
					pst.setFloat(2, q1);
					pst.setFloat(3, q2);
					pst.setFloat(4, q3);
					pst.setFloat(5, q4);
					pst.setDouble(6, totalsales);
					pst.setFloat(7, commission);
					pst.setInt(8, SalesmanNumber);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Updated!");
					table_load();

					txtSNumber.setText("");
					txtSName.setText("");
					txt1QS.setText("");
					txt2QS.setText("");
					txt3QS.setText("");
					txt4QS.setText("");
					txtSName.requestFocus();
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdate.setBounds(20, 515, 101, 45);
		frame.getContentPane().add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int SalesmanNumber = Integer.parseInt(txtSearchNumber.getText());
				try {
					pst = con.prepareStatement("delete from salesman where Salesman_Number =?");
					pst.setInt(1, SalesmanNumber);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Deleted...");
					table_load();

					txtSNumber.setText("");
					txtSName.setText("");
					txt1QS.setText("");
					txt2QS.setText("");
					txt3QS.setText("");
					txt4QS.setText("");
					txtSName.requestFocus();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(147, 515, 101, 45);
		frame.getContentPane().add(btnDelete);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExit.setBounds(275, 515, 101, 45);
		frame.getContentPane().add(btnExit);
	}
}
