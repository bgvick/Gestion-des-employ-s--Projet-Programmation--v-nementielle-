package supmti.sidik.gael;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class InterfaceGraphic extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nom;
	private JTextField Txt_salaire;
	private JTextField Txt_prime;
	private JRadioButton rb_noPrime;
	private JRadioButton rb_prime;
	private JButton btn_afficher, btn_masquer;
	private JDateChooser dateNaissanceChooser, date_EmbaucheChooser;
	
	String[][] rec = {};
	String dateNaissance, date_Embauche;
	
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGraphic frame = new InterfaceGraphic();
					
					Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\AST\\Documents\\Programmation\\Java\\4ième Année\\Gestion des employés (Projet Programmation événementielle)\\img.png");
					frame.setIconImage(img);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceGraphic() {
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(null);
		setTitle("Gestion des employ\u00E9(e)s");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 557, 264);
		
		JLabel lbl_nom = new JLabel("Nom :");
		lbl_nom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_nom.setBounds(103, 35, 35, 14);
		getContentPane().add(lbl_nom);
		
		JLabel lbl_dateNaissance = new JLabel("Date de naissance :");
		lbl_dateNaissance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_dateNaissance.setBounds(20, 65, 118, 14);
		getContentPane().add(lbl_dateNaissance);
		
		JLabel lbl_dateEmbauche = new JLabel("Date d'embauche :");
		lbl_dateEmbauche.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_dateEmbauche.setBounds(23, 95, 115, 14);
		getContentPane().add(lbl_dateEmbauche);
		
		JLabel lbl_salaire = new JLabel("Salaire :");
		lbl_salaire.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_salaire.setBounds(89, 125, 49, 14);
		getContentPane().add(lbl_salaire);
		
		JLabel lbl_prime = new JLabel("Prime :");
		lbl_prime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_prime.setBounds(93, 155, 45, 14);
		getContentPane().add(lbl_prime);
		
		JLabel lbl_montantPrime = new JLabel("Montant :");
		lbl_montantPrime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_montantPrime.setBounds(74, 185, 64, 14);
		getContentPane().add(lbl_montantPrime);
		
		
		/*TextBox*/
		txt_nom = new JTextField();
		txt_nom.setColumns(10);
		txt_nom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txt_nom.setBounds(148, 31, 217, 23);
		getContentPane().add(txt_nom);
		
		Txt_salaire = new JTextField();
		Txt_salaire.setText("0");
		Txt_salaire.setColumns(10);
		Txt_salaire.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Txt_salaire.setBounds(148, 121, 217, 23);
		getContentPane().add(Txt_salaire);
		
		Txt_prime = new JTextField();
		Txt_prime.setEnabled(false);
		Txt_prime.setText("0");
		Txt_prime.setColumns(10);
		Txt_prime.setBounds(148, 181, 217, 23);
		getContentPane().add(Txt_prime);
		Txt_prime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		/*RadioButton*/
		rb_prime = new JRadioButton("Oui");
		rb_prime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rb_prime.isSelected()) {
					Txt_prime.setEnabled(true);
					Txt_prime.setText("");
					rb_noPrime.setSelected(false);
				}
			}
		});
		rb_prime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rb_prime.setBounds(178, 151, 67, 23);
		getContentPane().add(rb_prime);
		
		
		rb_noPrime = new JRadioButton("Non");
		rb_noPrime.setSelected(true);
		rb_noPrime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rb_noPrime.isSelected()) {
					rb_prime.setSelected(false);
					Txt_prime.setText("0");
					Txt_prime.setEnabled(false);
				}
			}
		});
		rb_noPrime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rb_noPrime.setBounds(277, 151, 88, 23);
		getContentPane().add(rb_noPrime);
		
		/*Button*/
		JButton btn_ajouter = new JButton("Ajouter");
		btn_ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_ajouter_Click();
			}
		});
		btn_ajouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_ajouter.setBounds(382, 42, 135, 30);
		getContentPane().add(btn_ajouter);
		
		JButton btn_supprimer = new JButton("Supprimer");
		btn_supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_supprimer_Click();
			}
		});
		btn_supprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_supprimer.setBounds(382, 80, 135, 30);
		getContentPane().add(btn_supprimer);
		
		btn_afficher = new JButton("Afficher la liste");
		btn_afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
				btn_masquer.setVisible(true);
				btn_afficher.setVisible(false);
			}
		});
		btn_afficher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_afficher.setBounds(382, 118, 135, 30);
		getContentPane().add(btn_afficher);
		
		
		btn_masquer = new JButton("Masquer la liste");
		btn_masquer.setVisible(false);
		btn_masquer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 557, 264);
				btn_afficher.setVisible(true);
				btn_masquer.setVisible(false);
			}
		});
		btn_masquer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_masquer.setBounds(382, 118, 135, 30);
		getContentPane().add(btn_masquer);
		
		JButton btn_fermer = new JButton("Fermer");
		btn_fermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn_fermer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_fermer.setBounds(382, 162, 135, 30);
		getContentPane().add(btn_fermer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 227, 497, 260);
		getContentPane().add(scrollPane);
		
		
		/*Tableau*/
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Nom", "Date naissance", "Date d'embauche", "Salaire a payer", "Prime"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(104);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(113);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(113);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(106);
		scrollPane.setViewportView(table_1);
		
		dateNaissanceChooser = new JDateChooser();
		dateNaissanceChooser.setBounds(148, 59, 217, 23);
		getContentPane().add(dateNaissanceChooser);
		
		date_EmbaucheChooser = new JDateChooser();
		date_EmbaucheChooser.setBounds(148, 89, 217, 23);
		getContentPane().add(date_EmbaucheChooser);
			
	}
	
	
	private boolean showList() {
		setBounds(100, 100, 557, 537);
		
		return true;
	}
	
	
	private void btn_ajouter_Click(){
		if (!Vides()){
			
			try {
				double salaire = Double.parseDouble(Txt_salaire.getText());
	            double prime = Double.parseDouble(Txt_prime.getText());
	            Employes e = new Employes();
	            
	            
	            /*Pour formater la date en dd mm aaaa*/
	            Locale locale = new Locale("fr", "FR");
	            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
	            
	            dateNaissance = dateFormat.format(dateNaissanceChooser.getDate());
	            date_Embauche = dateFormat.format(date_EmbaucheChooser.getDate());
	            
	            if (salaire >= 0)
	            {
	                if (rb_prime.isSelected())
	                {
	                	
	                     String employes[] = {String.valueOf(e.getMatricule()),txt_nom.getText(), dateNaissance,
	                    		 date_Embauche, String.valueOf(salaire +" Dhs"), String.valueOf(prime +" Dhs")};
	                	
	                	DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
	                	tableModel.addRow(employes);
	                	after_btnAddClick();
	            
	                }
	                else
	                {
	                	prime = 0;
	                	String employes[] = {String.valueOf(e.getMatricule()),txt_nom.getText(), dateNaissance,
	                			date_Embauche, String.valueOf(salaire+" Dhs"), String.valueOf(prime+" Dhs")};
	               	
	                	DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
	                	tableModel.addRow(employes);
	                	after_btnAddClick();
	                }
	                
	            }
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(this,"Remplissez tous les champs de text !");
				}
            
        }
        else {
        	JOptionPane.showMessageDialog(this,"Remplissez tous les champs de text !");
        }
    }
	
	
	private void btn_supprimer_Click()
    {
		
		DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
		if(table_1.getSelectedRowCount() == 1) {
			int input = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cet employé?", "Confirmation",JOptionPane.YES_NO_OPTION);
			// 0=yes, 1=no, 2=cancel
			if(input == 0)
				tableModel.removeRow(table_1.getSelectedRow());
		}else {
			if(table_1.getRowCount() == 0) {
				JOptionPane.showMessageDialog(this,"La liste est déjà vide");
			}else {
				JOptionPane.showMessageDialog(this,"Selectionnez un employé");
			}
		}
		
    }
	
	private void after_btnAddClick() {
		JOptionPane.showMessageDialog(this,"L'employé(e) a bien été ajouter !");
		txt_nom.setText("");
		Txt_salaire.setText("");
        if (rb_prime.isSelected()) Txt_prime.setText("");
	}
	
	
	public boolean Vides(){
        return (txt_nom.getText().equals("")) || (Txt_salaire.getText().equals("")) || (Txt_prime.getText().equals(""));
    }
}
