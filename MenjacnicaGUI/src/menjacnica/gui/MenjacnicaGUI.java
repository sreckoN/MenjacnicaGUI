package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Rectangle;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panelEast;
	private JButton btnDodajKurs;
	private JButton btnObrisiKurs;
	private JButton btnIzvrsiZamenu;
	private JMenuBar menuBar;
	private JMenu mnFiles;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JScrollPane scrollPaneSouth;
	private JTextArea textAreaSouth;
	private JScrollPane scrollPaneCenter;
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmObrisiKurs;
	private JMenuItem mntmIzviZamenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
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
	public MenjacnicaGUI() {
		setTitle("Menjacnica");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/icons/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 340);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelEast(), BorderLayout.EAST);
		contentPane.add(getScrollPaneSouth(), BorderLayout.SOUTH);
		contentPane.add(getScrollPaneCenter(), BorderLayout.CENTER);
	}

	private JPanel getPanelEast() {
		if (panelEast == null) {
			panelEast = new JPanel();
			panelEast.setPreferredSize(new Dimension(120, 40));
			panelEast.add(getBtnDodajKurs());
			panelEast.add(getBtnObrisiKurs());
			panelEast.add(getBtnIzvrsiZamenu());
		}
		return panelEast;
	}
	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");
			btnDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DodajKursGUI dodaj = new DodajKursGUI();
					dodaj.setVisible(true);
					
				}
			});
		}
		return btnDodajKurs;
	}
	private JButton getBtnObrisiKurs() {
		if (btnObrisiKurs == null) {
			btnObrisiKurs = new JButton("Obrisi kurs");
			btnObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ObrisiKursGUI obrisi = new ObrisiKursGUI();
					obrisi.setVisible(true);
				}
			});
		}
		return btnObrisiKurs;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzvrsiZamenuGUI zamena = new IzvrsiZamenuGUI();
					zamena.setVisible(true);
				}
			});
		}
		return btnIzvrsiZamenu;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFiles());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFiles() {
		if (mnFiles == null) {
			mnFiles = new JMenu("File");
			mnFiles.add(getMntmOpen());
			mnFiles.add(getMntmSave());
			mnFiles.add(getMntmExit());
		}
		return mnFiles;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String tekst = textAreaSouth.getText();
					if(!tekst.isEmpty()) 
						tekst += "\n";
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showOpenDialog(menuBar);
					File f;
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						f = fc.getSelectedFile();
						tekst = tekst + "Ucitan fajl: " + f.getAbsolutePath();
						textAreaSouth.setText(tekst);
					}
					
				}
			});
			mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String tekst = textAreaSouth.getText();
					if(!tekst.isEmpty()) {
						tekst += "\n";
					}
					JFileChooser fc = new JFileChooser();
					int retVal = fc.showSaveDialog(menuBar);
					File f;
					if(retVal == JFileChooser.APPROVE_OPTION) {
						f = fc.getSelectedFile();
						tekst = tekst + "Sacuvan fajl: " + f.getAbsolutePath();
						textAreaSouth.setText(tekst);
					}
				}
			});
			mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					izlaz();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(menuBar, "Autor: Srecko Nikolic\nVerzija: 0.1", "About", JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return mntmAbout;
	}
	private JScrollPane getScrollPaneSouth() {
		if (scrollPaneSouth == null) {
			scrollPaneSouth = new JScrollPane();
			scrollPaneSouth.setPreferredSize(new Dimension(2, 80));
			scrollPaneSouth.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPaneSouth.setViewportView(getTextAreaSouth());
		}
		return scrollPaneSouth;
	}
	private JTextArea getTextAreaSouth() {
		if (textAreaSouth == null) {
			textAreaSouth = new JTextArea();
		}
		return textAreaSouth;
	}
	private JScrollPane getScrollPaneCenter() {
		if (scrollPaneCenter == null) {
			scrollPaneCenter = new JScrollPane();
			scrollPaneCenter.setViewportView(getTable());
		}
		return scrollPaneCenter;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFillsViewportHeight(true);
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"\u0160ifra", "Skra\u0107eni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"
				}
			));
			addPopup(table, getPopupMenu());
			table.getColumnModel().getColumn(1).setPreferredWidth(81);
		}
		return table;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmObrisiKurs());
			popupMenu.add(getMntmIzviZamenu());
		}
		return popupMenu;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj Kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DodajKursGUI dodaj = new DodajKursGUI();
					dodaj.setVisible(true);
				}
			});
		}
		return mntmDodajKurs;
	}
	private JMenuItem getMntmObrisiKurs() {
		if (mntmObrisiKurs == null) {
			mntmObrisiKurs = new JMenuItem("Obrisi Kurs");
			mntmObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ObrisiKursGUI obrisi = new ObrisiKursGUI();
					obrisi.setVisible(true);
				}
			});
		}
		return mntmObrisiKurs;
	}
	private JMenuItem getMntmIzviZamenu() {
		if (mntmIzviZamenu == null) {
			mntmIzviZamenu = new JMenuItem("Izv\u0161i zamenu");
			mntmIzviZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IzvrsiZamenuGUI zamena = new IzvrsiZamenuGUI();
					zamena.setVisible(true);
				}
			});
		}
		return mntmIzviZamenu;
	}
	private void izlaz() {
		int opcija = JOptionPane.showConfirmDialog(menuBar, "Da li zelite da izadjete?", "Izlaz", JOptionPane.YES_NO_OPTION);
		if(opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
