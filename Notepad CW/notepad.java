/* I Got Bored
/////////////////////////////////////////
*****************************************
-----------------------------------------
|			Rajiv Ahmed					|
|			W1431880					|
|	BSc (Hons) Computer Network Security|
|										|
|	University of Westminster			|
|			EECT520						|
|	Event Driven & GUI Programming		|
-----------------------------------------
*****************************************
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
*/

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.Robot.*;
import javax.swing.text.*;
import java.awt.print.*;
import java.awt.datatransfer.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.undo.*;
import javax.swing.filechooser.*;
import java.awt.Dialog.*;

public class notepad 
{
	//main method constructs the frame window
	public static void main(String[] args)
	{
		//Window Layout
		final JFrame layout = new JFrame();
		layout.setTitle("Java - Notepad");
		layout.setLocation(250, 250); //sets starting position
		layout.setSize(960, 540); //sets initial size
		layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close window
		layout.setVisible(true);//shows window
	
		//GUI
		/*Menu Bar*/
		MenuBar MnBr = new MenuBar();
		layout.setMenuBar(MnBr);
		
		/*Application Icon*/
		ImageIcon appIcon = new ImageIcon("Images/Notepad.png");
		layout.setIconImage(appIcon.getImage());
		
		/*Text Area*/
		final JTextArea txtAr = new JTextArea();
		layout.getContentPane().add(txtAr);
		txtAr.setEditable(true);
		txtAr.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		
		/*Scrollbar*/
		JScrollPane scrlbr = new JScrollPane(txtAr);
		scrlbr.setPreferredSize(new Dimension(100,150));
		scrlbr.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrlbr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		layout.add(scrlbr);
		
		/*Toolbar*/
		final JToolBar tlbr = new JToolBar(JToolBar.HORIZONTAL);
		tlbr.setPreferredSize(new Dimension(100, 40));
		tlbr.setRollover(true);
		tlbr.setFloatable(false);
		layout.add(tlbr, BorderLayout.NORTH);
		
		//Menu Bar Options
		Menu file = new Menu("File");
		Menu edit = new Menu("Edit");
		Menu format = new Menu("Format");
		Menu view = new Menu("View");
		Menu help = new Menu("Help");
		
		MnBr.add(file);
		MnBr.add(edit);
		MnBr.add(format);
		MnBr.add(view);
		MnBr.add(help);
		
		//File Options
		MenuItem FlNew = new MenuItem("New");
		MenuItem FlOpen = new MenuItem("Open");
		MenuItem FlSave = new MenuItem("Save");
		MenuItem FlExit = new MenuItem("Exit");
	
		file.add(FlNew);
		file.add(FlOpen);
		file.add(FlSave);
		file.add(FlExit);
		
		FlNew.setShortcut(new MenuShortcut(KeyEvent.VK_N,false));
		FlOpen.setShortcut(new MenuShortcut(KeyEvent.VK_O,false));
		FlSave.setShortcut(new MenuShortcut(KeyEvent.VK_S,false));
		FlExit.setShortcut(new MenuShortcut(KeyEvent.VK_W,false));
		
		final JButton NwBtn = new JButton(new ImageIcon("Images/new.png"));
		NwBtn.setToolTipText("Create a new text file");
		tlbr.add(NwBtn);
		
		final JButton OpBtn = new JButton(new ImageIcon("Images/open.png"));
		OpBtn.setToolTipText("Open a text file");
		tlbr.add(OpBtn);
		
		final JButton SvBtn = new JButton(new ImageIcon("Images/save.png"));
		SvBtn.setToolTipText("Save current text file");
		tlbr.add(SvBtn);
		
		//Edit Options
		MenuItem EdUndo = new MenuItem("Undo"); 
		MenuItem EdRedo = new MenuItem("Redo");
		MenuItem EdCopy = new MenuItem("Copy");
		MenuItem EdCut = new MenuItem("Cut");
		MenuItem EdPaste = new MenuItem("Paste");
		MenuItem EdSelAl = new MenuItem("Select All");
		
		/*edit.add(EdSearch);*/
		edit.add(EdUndo);
		edit.add(EdRedo);
		edit.add(EdCopy);
		edit.add(EdCut);
		edit.add(EdPaste);
		edit.add(EdSelAl);
		
		final UndoManager unrefunc = new UndoManager();
		final Clipboard clpbd = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		EdUndo.setShortcut(new MenuShortcut(KeyEvent.VK_Z,false));
		EdRedo.setShortcut(new MenuShortcut(KeyEvent.VK_Y,false));
		EdCopy.setShortcut(new MenuShortcut(KeyEvent.VK_C,false));
		EdCut.setShortcut(new MenuShortcut(KeyEvent.VK_X,false));
		EdPaste.setShortcut(new MenuShortcut(KeyEvent.VK_V,false));
		EdSelAl.setShortcut(new MenuShortcut(KeyEvent.VK_A,false));
		
		final JButton CpBtn = new JButton(new ImageIcon("Images/copy.png"));
		SvBtn.setToolTipText("Copy highlighted text");
		tlbr.add(CpBtn);
		
		final JButton CtBtn = new JButton(new ImageIcon("Images/cut.png"));
		SvBtn.setToolTipText("Cut highlighted text");
		tlbr.add(CtBtn);
		
		final JButton PstBtn = new JButton(new ImageIcon("Images/paste.png"));
		SvBtn.setToolTipText("Paste text in Text Area");
		tlbr.add(PstBtn);
		
		final JButton UnBtn = new JButton(new ImageIcon("Images/undo.png"));
		SvBtn.setToolTipText("Undo last action or character");
		tlbr.add(UnBtn);
		
		final JButton ReBtn = new JButton(new ImageIcon("Images/redo.png"));
		SvBtn.setToolTipText("Redo last action or character");
		tlbr.add(ReBtn);		
		
		//Format Options
		MenuItem FrFntClr = new MenuItem("Font Colour");
		MenuItem FrFont = new MenuItem("Font Styler");
		
		format.add(FrFntClr);
		format.add(FrFont);
		
		//View Options
		Menu VwWrdWrp = new Menu("Word Wrap");
		final MenuItem VwVirtKb = new MenuItem("Virtual Keyboard");
		final MenuItem EnWrdWrp = new MenuItem("Enable");
		final MenuItem DisWrdWrp = new MenuItem("Disable");
		
		view.add(VwWrdWrp);
		view.add(VwVirtKb);
		
		VwWrdWrp.add(EnWrdWrp);
		VwWrdWrp.add(DisWrdWrp);
		
		final JButton KbBtn = new JButton(new ImageIcon("Images/kb.png"));
		SvBtn.setToolTipText("Open On-Screen Keyboard");
		tlbr.add(KbBtn);
		
		//Help Options
		MenuItem HlpAb = new MenuItem("About");
		
		help.add(HlpAb);
		
		//File Options - Actions
		/*File > New*/
		ActionListener NwAc = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int choice = JOptionPane.showConfirmDialog(layout, "Would you like to save the current file?", "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
				if(choice == JOptionPane.YES_OPTION)
				{
					JFileChooser flsv = new JFileChooser();
					FileNameExtensionFilter fltr = new FileNameExtensionFilter("*.txt", "txt");
					flsv.setFileFilter(fltr);
					int SvFl = flsv.showOpenDialog(null);
					if (SvFl == JFileChooser.APPROVE_OPTION)
					{
						try 
						{
							BufferedWriter out = new BufferedWriter(new FileWriter(flsv.getSelectedFile().getPath()));
							out.write(txtAr.getText());
							out.close();
						} 
						catch (Exception ex) 
						{
							System.out.println(ex.getMessage());
						}
					}
				}
				else if(choice == JOptionPane.NO_OPTION)
				{
					txtAr.setText("");
				}
			}
		};
		FlNew.addActionListener(NwAc);
		NwBtn.addActionListener(NwAc);
		
		/*File > Open*/
		ActionListener OpAc = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser flop = new JFileChooser();
				FileNameExtensionFilter fltr = new FileNameExtensionFilter("*.txt", "txt");
				flop.setFileFilter(fltr);
				int OpFl = flop.showOpenDialog(null);
				if (OpFl == JFileChooser.APPROVE_OPTION)
				{
					txtAr.setText("");
					try
					{
						Scanner scn = new Scanner(new FileReader(flop.getSelectedFile().getPath()));
						while (scn.hasNext())
						txtAr.append(scn.nextLine() + "\n");
					} 
					catch (Exception ex)
					{
						System.out.println(ex.getMessage());
					}
				}
			}
		};
		FlOpen.addActionListener(OpAc);
		OpBtn.addActionListener(OpAc);		
		
		/*File > Save*/
		ActionListener SvAc = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser flsv = new JFileChooser();
				FileNameExtensionFilter fltr = new FileNameExtensionFilter("*.txt", "txt");
				flsv.setFileFilter(fltr);
				int SvFl = flsv.showSaveDialog(null);
				if (SvFl == JFileChooser.APPROVE_OPTION)
				{
					try 
					{
						BufferedWriter out = new BufferedWriter(new FileWriter(flsv.getSelectedFile().getPath() + ".txt"));
						out.write(txtAr.getText());
						out.close();
					} 
					catch (Exception ex) 
					{
						System.out.println(ex.getMessage());
					}
				}
			}
		};
		FlSave.addActionListener(SvAc);
		SvBtn.addActionListener(SvAc);		
		
		/*File > Exit*/
		FlExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		//Edit Options - Actions
		/*Edit > Undo*/
		txtAr.getDocument().addUndoableEditListener(new UndoableEditListener()
		{
			public void undoableEditHappened(UndoableEditEvent u)
			{
				unrefunc.addEdit(u.getEdit());
			}
		});
		ActionListener UnAc = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					unrefunc.undo();
				}
				catch (Exception cre)
				{
					JOptionPane.showMessageDialog(null, "Type some text before using undo function", "Error: Incorrect Use of Function", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		};
		EdUndo.addActionListener(UnAc);
		UnBtn.addActionListener(UnAc);
		
		/*Edit > Redo*/
		ActionListener ReAc = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					unrefunc.redo();
				}
				catch (CannotRedoException cre)
				{
					JOptionPane.showMessageDialog(null, "Use undo function before using redo function", "Error: Incorrect Use of Function", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		};
		EdRedo.addActionListener(ReAc);
		ReBtn.addActionListener(ReAc);
		
		/*Edit > Copy*/
		ActionListener CpAc = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String copyclip= txtAr.getSelectedText();
					StringSelection clpstrng = new StringSelection(copyclip);
					clpbd.setContents(clpstrng, clpstrng);
				}
				catch (Exception ex)
				{
					
				}
			}
		};
		EdCopy.addActionListener(CpAc);
		CpBtn.addActionListener(CpAc);
		
		/* Edit > Cut*/
		ActionListener CtAc = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String copyclip= txtAr.getSelectedText();
					StringSelection clpstrng = new StringSelection(copyclip);
					clpbd.setContents(clpstrng, clpstrng);
					txtAr.replaceRange("", txtAr.getSelectionStart(),
					txtAr.getSelectionEnd());
				}
				catch (Exception ex)
				{
					
				}
			}
		};
		EdCut.addActionListener(CtAc);
		CtBtn.addActionListener(CtAc);
		
		/*Edit > Paste*/
		ActionListener PstAc = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Transferable pstbd = clpbd.getContents(txtAr); 
                try
                {
                    String clpstrng = (String)pstbd.getTransferData(DataFlavor.stringFlavor);
                    txtAr.replaceRange(clpstrng,txtAr.getSelectionStart(), txtAr.getSelectionEnd());
                }
                catch(Exception ex)
                {
					
				}
            }
        };
		EdPaste.addActionListener(PstAc);
		PstBtn.addActionListener(PstAc);
		
		/*Edit > Select All*/
		EdSelAl.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					txtAr.selectAll();
				}
				catch (Exception ex)
				{
					
				}
			}
		});

		//Format Options - Actions
		/*Format > Font Colour*/
		FrFntClr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Color fntclr1 = JColorChooser.showDialog(null, "Change Text Colour - Note: All text will change!", Color.BLACK);
				txtAr.setForeground(fntclr1);
			}
			
		});
		
		//Format Options - Actions
		/*Format > Font Styler*/
		FrFont.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JPanel FntPan = new JPanel();
				JLabel FntFamLab = new JLabel("Choose Font Family	");
				JLabel FntSizeLab = new JLabel("Choose Font Size	");
				JButton ansOK = new JButton("OK");
				JButton ansCncl = new JButton("CANCEL");
				
				String[] fntfam1 = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
				final JComboBox <String> famcombo = new JComboBox<>(fntfam1);
				Vector vsize = new Vector();
				for (int i=2; i<=72; i+=2) 
				{
					vsize.addElement("" + i);
				}
				final JComboBox sizecombo = new JComboBox(vsize);
				
				FntPan.setLayout(new GridBagLayout());
				GridBagConstraints FntFrame = new GridBagConstraints();
				FntFrame.weightx = 2.5;
				FntFrame.weighty = 2.5;

				FntFrame.gridx = 1;
				FntFrame.gridy = 1;
				FntPan.add(FntFamLab, FntFrame);
			
				FntFrame.anchor = GridBagConstraints.LINE_START;
				FntFrame.gridx = 3;
				FntFrame.gridy = 1;
				FntPan.add(famcombo, FntFrame);
			
				FntFrame.anchor = GridBagConstraints.CENTER;
				FntFrame.gridx = 1;
				FntFrame.gridy = 3;
				FntPan.add(FntSizeLab, FntFrame);
			
				FntFrame.anchor = GridBagConstraints.LAST_LINE_START;
				FntFrame.gridx = 3;
				FntFrame.gridy = 3;
				FntPan.add(sizecombo, FntFrame);
			
				FntFrame.anchor = GridBagConstraints.CENTER;
				FntFrame.gridx = 3;
				FntFrame.gridy = 5;
				FntPan.add(ansOK, FntFrame);
			
				FntFrame.anchor = GridBagConstraints.LINE_END;
				FntFrame.gridx = 3;
				FntFrame.gridy = 5;
				FntPan.add(ansCncl, FntFrame);
			
				final JDialog FntDiag = new JDialog(layout, "Font");
				FntDiag.add(FntPan);
				FntDiag.setAlwaysOnTop(true);
				FntDiag.setSize(500,300);
				FntDiag.setResizable(false);
				sizecombo.setPreferredSize(new Dimension(100,50));
				
				int DefFnt = txtAr.getFont().getSize();
				String DFString = String.valueOf(DefFnt);
				sizecombo.getSelectedItem().toString();
				String usingFnt = txtAr.getFont().getFamily();
				famcombo.setSelectedItem(usingFnt);
				
				ansOK.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{	
						String FrFntSize = sizecombo.getSelectedItem().toString();
						int i = Integer.parseInt(FrFntSize);
						if(i<=0)
						{
							
						}
						else if(i>1)
						{
							Object fontfam = famcombo.getSelectedItem();
							Font fontfam1 = new Font(fontfam.toString(),0,i);
							txtAr.setFont(fontfam1);
							FntDiag.dispose();
						}
					}
				});
			
				ansCncl.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						FntDiag.dispose();
					}
				});
			
				FntDiag.setVisible(true);
			}
		});
		
		//View Options - Actions
		/*View > Word Wrap > Enable*/
		EnWrdWrp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if((e.getSource()==EnWrdWrp))
				{
					try
					{
						txtAr.setLineWrap(true);
						txtAr.setWrapStyleWord(true);
					}
					catch (Exception ex) 
					{
						
					}
				}
			}
		});
		
		/*View > Word Wrap > Disable*/
		DisWrdWrp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if((e.getSource()==DisWrdWrp))
				{
					try
					{
						txtAr.setLineWrap(false);
						txtAr.setWrapStyleWord(false);
					}
					catch (Exception ex) 
					{
						
					}
				}
			}
		});
		
		ActionListener KbAc = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					VirtKeyB.main();
				}
				catch (Exception ex)
				{
					
				}
			}
		};
		VwVirtKb.addActionListener(KbAc);
		KbBtn.addActionListener(KbAc);

		/*Help > About*/
		HlpAb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Notepad & Keyboard\nDeveloped by Rajiv Ahmed\nW1431880","UoW - EECT520", JOptionPane.INFORMATION_MESSAGE);
			}
		});	
	}//end of main
} //end of program