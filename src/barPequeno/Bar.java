package barPequeno;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Semaphore;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bar 
{
	private JFrame bar;
	private Mesa mesa;
	private Fila fila;
	private Semaphore qnt_clientes,mutex,mutex2;
	private JLabel lb_bar;
	private ImageIcon im_bar;
	private JButton bt_add;
	private ImageIcon im_add;
	
	Cliente aux;
	
/* --------------------------------------------------------------------------------------------- */
	
	public Bar(int numeroDeCadeiras) 
	{
//		Random gerador = new Random();
		
		this.mesa = new Mesa(numeroDeCadeiras);
		this.qnt_clientes = new Semaphore(numeroDeCadeiras);
		this.mutex = new Semaphore(1);
		this.mutex2 = new Semaphore(1);
		this.fila = new Fila();
		
		//this.id = gerador.nextInt(21);
		
		im_bar = loadImageBar(numeroDeCadeiras);
		im_add = loadImage("../imgs/locais/add_default.png", "Adicionar Cliente");
		lb_bar = new JLabel(im_bar);
		bt_add = new JButton(im_add);
		lb_bar.setBounds(0, 0, 1280, 768);
		bt_add.setBounds(50, 10, 60, 60);
		bt_add.setBackground(new Color(0, 0, 0, 0));
		bt_add.setBorder(null);
		bt_add.setFocusable(false);
    	bt_add.setContentAreaFilled(false);
    	bt_add.setBorderPainted(false);
		
		
		bt_add.addMouseListener(new MouseListener() 
		{
            public void mouseClicked(MouseEvent e) 
            {
            	String tempo_bar = "", tempo_casa = "", nome = "Sem nome";
            	JTextField barField = new JTextField(5);
                JTextField homeField = new JTextField(5);
                JPanel myPanel = new JPanel();
                
                nome = JOptionPane.showInputDialog(bar, "Nome do Cliente");
                
                myPanel.add(new JLabel("Tempo no Bar:"));
                myPanel.add(barField);
                myPanel.add(Box.createHorizontalStrut(15)); 
                myPanel.add(new JLabel("Tempo em Casa:"));
                myPanel.add(homeField);

                int result = JOptionPane.showConfirmDialog(null, myPanel, 
                         "Insira os Tempos", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) 
                {
                   tempo_bar = barField.getText();
				   tempo_casa = homeField.getText();
                }
                
                if(tempo_bar == null || tempo_bar == "" || tempo_casa == null || tempo_casa == "") 
                {
            		
            	} else 
            	{
            		try 
            		{
            			int tb, tc;
            			tb = Integer.parseInt(tempo_bar);
            			tc = Integer.parseInt(tempo_casa);
            			aux = new Cliente(bar, lb_bar, qnt_clientes, mutex, mutex2, fila, mesa, nome, tb, tc);
            			mutex.acquire();
            			fila.insereCliente(aux);
            			mutex.release();
            			System.out.println(tb + " " + tc);
            			System.out.println("Cliente inserido ID: "+ aux.getId() + " Nome: " +aux.getNome());
            			aux.start();
                    }
                    catch(Exception er) 
            		{
                        JOptionPane.showMessageDialog(bar, "Valor inválido");
                    }
            	}
            }
            public void mousePressed(MouseEvent e) {
            	
            }
            public void mouseReleased(MouseEvent e) {
            	
            }
            public void mouseEntered(MouseEvent e) {
                bt_add.setIcon(loadImage("../imgs/locais/add_entered.png", "Adicionar Cliente"));
            }
            public void mouseExited(MouseEvent e) {
            	bt_add.setIcon(loadImage("../imgs/locais/add_default.png", "Adicionar Cliente"));
            }
        });
		
		bar = new JFrame("Bar Pequeno");
		bar.setLayout(null);
		bar.setSize(1280, 768);
		bar.setLocationRelativeTo(null);
		bar.add(bt_add);
		bar.add(lb_bar);
		bar.setResizable(false);
		bar.setVisible(true);
	}
	
/* --------------------------------------------------------------------------------------------- */	

/*!
 * @brief Faz a instancia de todos os clientes dejados no inicio do programa.
 * @return void.
 */
//	TODO: NECESSARIO ARMAZENAR OS TEMPOS DE CADA CLIENTE EM CASA E NO BAR, ARMAZENAR ISSO EM UM TIPO 'Tempos' E DEPOIS LINKAR.
//  TODO: ATUALMENTE O CLIENTE RECEBE DOIS TEMPOS, DESEJADO: CLIENTE JA RECEBER O TIPO 'Tempos'.
	//private void iniciaFila(){
	//	for(int i = 0; i <= numeroDeClientes;i++) fila.insereCliente( new Cliente(bar, i, qnt_clientes, 3000, 3000));
	//}
	
//	private void proximoFila() 
//	{
//		try 
//		{
//			this.qnt_clientes.acquire();
//		} 
//		catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		fila.removeCliente().run();
//		this.qnt_clientes.release();
//	}
	
/* --------------------------------------------------------------------------------------------- */	
	
	public ImageIcon loadImageBar(int numeroDeCadeiras) 
	{
		return loadImage("../imagens/Bar" + numeroDeCadeiras + ".png","Mesa com " + numeroDeCadeiras + " cadeiras");
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
