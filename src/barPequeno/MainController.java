package barPequeno;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainController
{
	private JFrame jf_menu;
	private JLabel lb_menu;
	private JButton bt_start;
	private JButton bt_exit;
	private ImageIcon im_menu;
	private ImageIcon im_start;
	private ImageIcon im_exit;
	private ImageIcon im_start_onmouseover;
	private ImageIcon im_exit_onmouseover;
	
/* --------------------------------------------------------------------------------------------- */
	
	public MainController() 
	{
		jf_menu = new JFrame("Bar Pequeno");
		im_menu = loadImage("../imagens/barGif.gif", "Menu");
		
		im_start = loadImage("../imagens/bt_start.png", "Iniciar");
		im_exit = loadImage("../imagens/bt_exit.png", "Sair");
		im_start_onmouseover = loadImage("../imagens/bt_start_mouseover.png", "Iniciar Entered");
		im_exit_onmouseover = loadImage("../imagens/bt_exit_mouseover.png", "Sair Entered");
		
		lb_menu = new JLabel(im_menu);
		bt_start = new JButton();
		bt_exit = new JButton();
		bt_start.setIcon(im_start);
		bt_exit.setIcon(im_exit);
		
		bt_start.addMouseListener(new MouseListener() 
		{
            public void mouseClicked(MouseEvent e) 
            {
            	int cadeiras;
            	try 
            	{
                	int numCadeiras = Integer.parseInt(JOptionPane.showInputDialog(jf_menu, "Digite o número de cadeiras: "));

	            	if (!(numCadeiras >= 1 && numCadeiras <= 10)) {
	            		JOptionPane.showMessageDialog(jf_menu, "Valor inválido para cadeiras.", null, JOptionPane.ERROR_MESSAGE);
	            		
	            	}
	            	else 
	            	{
                        cadeiras = numCadeiras;
                        iniciar(cadeiras);
                        jf_menu.dispose();
                    }
            	}
            	catch(NumberFormatException ex) {
            		JFrame error = new JFrame();
                    JOptionPane.showMessageDialog(error, "Valor inválido para cadeiras.", null, JOptionPane.ERROR_MESSAGE);
            	}
            }
            public void mousePressed(MouseEvent e) {
            	
            }
            public void mouseReleased(MouseEvent e) {
            	
            }
            public void mouseEntered(MouseEvent e) {
                bt_start.setIcon(im_start_onmouseover);
            }
            public void mouseExited(MouseEvent e) {
            	bt_start.setIcon(im_start);
            }
        });
		
		bt_exit.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            	System.exit(0);
            }
            public void mousePressed(MouseEvent e) {
            }
            public void mouseReleased(MouseEvent e) {
            	
            }
            public void mouseEntered(MouseEvent e) {
                bt_exit.setIcon(im_exit_onmouseover);
            }
            public void mouseExited(MouseEvent e) {
            	bt_exit.setIcon(im_exit);
            }
        });
	}
	
/* --------------------------------------------------------------------------------------------- */	
	
	public void show() 
	{
		lb_menu.setBounds(0 ,0 , 1200, 768);
		bt_start.setBounds(920, 540, 171, 55);
		bt_exit.setBounds(920, 600, 171, 55);
		bt_start.setBackground(new Color(0, 0, 0, 0));
		bt_exit.setBackground(new Color(0, 0, 0, 0));
		bt_start.setFocusable(false);
		bt_start.setBorder(null);
		bt_exit.setFocusable(false);
		bt_start.setContentAreaFilled(false);
    	bt_start.setBorderPainted(false);
		bt_exit.setBorder(null);
		jf_menu.add(bt_start);
		jf_menu.add(bt_exit);
		jf_menu.add(lb_menu);
		jf_menu.setSize(1200, 768);
		jf_menu.setLocationRelativeTo(null);
		jf_menu.setResizable(false);
		jf_menu.setVisible(true);
	}

/* --------------------------------------------------------------------------------------------- */
	
	public void iniciar(int numeroDeCadeiras) {
		new Bar(numeroDeCadeiras);
	}
	
/* --------------------------------------------------------------------------------------------- */
		
	public ImageIcon loadImage(String path, String name) 
	{
		java.net.URL img = getClass().getResource(path);
		if (img != null) {
			return new ImageIcon(img, name);
		} 
		else 
		{
			System.err.println("Nao foi possivel carregar o arquivo de imagem: " + path);
			return null;
		}
	}
	
/* --------------------------------------------------------------------------------------------- */	
	
}
