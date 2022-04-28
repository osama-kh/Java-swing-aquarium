package start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;


import q3.Fish;
import q3.Jellyfish;
import q3.Swimmable;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @author osama khawaled 319118717
 * @author mohamed hamad 323002592
 */

public class AquaFrame extends JFrame {

	/**
	 * Launch the application.
	 * the main frame of the aquarium 
	 * 
	 */
	//Initialization of the variables
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JButton Reset = new JButton("Reset");
	private AddAnimalDialog temp;
	public static ArrayList<Swimmable> creatures = new ArrayList<>();
	private boolean Istablevisible=false;
	public static int width,hight;
	public static int winner_count=0;
	JScrollPane scrollPane;


    

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AquaFrame frame =  new AquaFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
					System.out.println(creatures);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * and make it visible
	 */
	public AquaFrame() {
		/**
		 * Initialization of the frame components and to open it
		 */
		setTitle("my Aquarium");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 566);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu File = new JMenu("File");
		File.setActionCommand("File");
		menuBar.add(File);
		JMenuItem exit = new JMenuItem("Exit");
		File.add(exit);
		JMenu Background = new JMenu("Background");
		menuBar.add(Background);
		JMenuItem Image = new JMenuItem("Image");
		Background.add(Image);
		JMenuItem Blue = new JMenuItem("Blue");
		Background.add(Blue);
		JMenuItem None = new JMenuItem("None");
		Background.add(None);
		JMenu Help = new JMenu("Help");
		menuBar.add(Help);
		JMenuItem Help_x = new JMenuItem("Help");
		Help.add(Help_x);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel options_panel = new JPanel();
		options_panel.setLayout(new GridLayout(0, 7, 0, 0));
		JButton Add_Animal = new JButton("Add Animal");
		options_panel.add(Add_Animal);
		JButton Sleep = new JButton("Sleep");
		options_panel.add(Sleep);
		JButton Wake_up = new JButton("Wake up");
		options_panel.add(Wake_up);
		options_panel.add(Reset);
		JButton Food = new JButton("Food");
		options_panel.add(Food);
		JButton Info = new JButton("Info");
		options_panel.add(Info);
		//shut down the program
		JButton Exit = new JButton("Exit");
		options_panel.add(Exit);
		
		
		

		
		
		
		contentPane.add(options_panel, BorderLayout.SOUTH);
		 AquaPanel main_panel = new AquaPanel();
		contentPane.add(main_panel, BorderLayout.CENTER);
		
		//actions
		//add action listener to the buttons in the menu bar
		//Exit button to exit the frame
		Exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				dispose();
			}
			});
		
		
		//exit button to exit the frame
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
			});
		
		//Image button to set an Image into the panel
		Image.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(null);
				((AquaPanel) main_panel).setBlue_background(false);
				((AquaPanel) main_panel).setCheck(true);
			}
		});
		
		//Blue button to set an the background of the panel in blue color
		Blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((AquaPanel) main_panel).setCheck(false);
				((AquaPanel) main_panel).setBlue_background(true);
			}
			});
		
		//None button to set an empty background to the panel
		None.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main_panel.setBackground(null);
				((AquaPanel) main_panel).setCheck(false);
				((AquaPanel) main_panel).setBlue_background(false);
				contentPane.setBackground(null);

			}
			});
		
		//Help_x button to open a dialog with message
		 Help_x.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog(null,"Home Work 3 \n GUI @ Threads","Message",1);
				
			}
			});
		 
		//Add_Animal button to add a new animal to the panel
		 Add_Animal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				width=main_panel.getWidth();
				hight=main_panel.getHeight();
				if(creatures.size()!=5) {
				temp=new AddAnimalDialog();
				temp.setVisible(true);
				}
				else {
			        JOptionPane.showMessageDialog(null,"There are no place for another animal!","Error",1);
				}
				main_panel.setAnimal_trig(true);
				main_panel.repaint();
			}
			});
		 
		//Sleep button to put the animal in sleep mood
		 Sleep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=0;
				while(i<creatures.size()) {
					if(creatures.get(i) instanceof Fish) {
						((Fish) creatures.get(i)).setSuspend();
					}
					else if (creatures.get(i) instanceof Jellyfish){
						System.out.println("sleep actionliestner jellyjish");
						((Jellyfish) creatures.get(i)).setSuspend();
					}
				i++;}
			}
		});
		 
		//Wake_up button to get out from sleep mood
		 Wake_up.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=0;
				while(i<creatures.size()) {
					if(creatures.get(i) instanceof Fish) {
						((Fish) creatures.get(i)).setResume();;
					}
					else if (creatures.get(i) instanceof Jellyfish){
						System.out.println("sleep actionliestner jellyjish");
						((Jellyfish) creatures.get(i)).setResume();
					}
				i++;}
			}
		});
		 
		//Reset button to remove all the animals from the aquarium
		 Reset.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					int i=0;
					while(i<creatures.size()) {
						if(creatures.get(i) instanceof Fish) {
							
							((Fish) creatures.get(i)).stop();
						}
						else if (creatures.get(i) instanceof Jellyfish){
							System.out.println("sleep actionliestner jellyjish");
							((Jellyfish) creatures.get(i)).stop();
						}
					i++;}
					creatures = new ArrayList<>();
				    main_panel.setAnimals_in_aquarium(new HashSet<Swimmable> ());
				    System.out.println("reset");
				}
			});
		 
		    
			//Info button to show the animals information in a table
		    Info.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if(Istablevisible==false) {
								//main_panel.setInfo_locker(false);
							String column[]={"Animal","Color","Size","Hor.speed","Ver.speed","Eat counter"};   
							String data[][]=new String[creatures.size()+1][column.length];    

						    int i=0;
						    int eatcountsum=0;
						    for(Swimmable animal : creatures) {
						    	data[i][0]=""+animal.getAnimalName();
						    	data[i][1]=""+animal.getColor();
						    	data[i][2]=""+Integer.toString(animal.getSize());
						    	data[i][3]=""+Integer.toString(animal.getHorspeed());
						    	data[i][4]=""+Integer.toString(animal.getVerspeed());
						    	data[i][5]=""+Integer.toString(animal.getEatCount());
						    	eatcountsum+=animal.getEatCount();
						    	i++;
						    }
						    data[creatures.size()][0]="Total";
						    data[i][5]=""+Integer.toString(eatcountsum);
		 
						    JTable info_table=new JTable(data , column) ;
				 		    scrollPane = new JScrollPane(info_table);
				 		    scrollPane.setSize(450,info_table.getRowHeight()*(creatures.size()+1)+24);
				 		    main_panel.add(scrollPane);
				 		    //add( scrollPane, BorderLayout.CENTER );
				 		    Istablevisible = true;				    
					
							}
							   else {
									main_panel.setInfo_locker(true);

								   Istablevisible = false;
						 	   
						 	   scrollPane.setVisible(Istablevisible);
						 	  }
						}
					});

			//Food button to put a warm in the aquarium to feed the animals
		    Food.addActionListener(new ActionListener()  {
				@Override
				public void actionPerformed(ActionEvent e) {
					winner_count=0;
					CyclicBarrier temp=new CyclicBarrier(creatures.size(),new Runnable() {
						@Override
						public void run() {
							while(true) {
							try {
								Thread.sleep(100);
								for (Swimmable animal : creatures) { 								
											if(animal instanceof Fish) {
												((Fish) animal).centermove();										
											}
											else if (animal instanceof Jellyfish){
												((Jellyfish) animal).centermove();}
								}
							} 		
								catch (InterruptedException e) {
								// TODO Auto-generated catch block 
								e.printStackTrace();
							}
						}
						}
					});
					for (Swimmable animal : creatures) {
						if(animal instanceof Fish) {
							((Fish) animal).setCyclic(true);
						}
						else if (animal instanceof Jellyfish){
							((Jellyfish) animal).setCyclic(true);
						}
						animal.setBarrier(temp);
						System.out.println("setcyclic passed");
						new Thread(animal);
						}
					main_panel.setFood(true);
				}
			});

	}
}
