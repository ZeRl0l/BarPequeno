package barPequeno;

import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Cliente extends Thread 
{
	@SuppressWarnings("unused")
	private int numCadeiras;
	private Semaphore qnt_clientes, mutex, mutex2;
	private Fila fila;
	private Mesa mesa;
	private Tempos tempos;
	JFrame bar;
	int filaCoordenadas[] = {270, 240, 210, 190, 160, 130, 100, 70, 40, 10};

	String nome = "";

	JLabel fundo;
	JLabel sprite;
	int flag = 1;

	ImageIcon sp1; // andando
	ImageIcon sp2;
	ImageIcon sp3;
	ImageIcon sp4;
	ImageIcon sp5;
	ImageIcon sp6;
	ImageIcon sp7;
	ImageIcon sp8;
	ImageIcon sp9;
	ImageIcon bb1; // bebendo
	ImageIcon bb2;
	
/* --------------------------------------------------------------------------------------------- */	

	public Cliente(JFrame bar, JLabel fundo, Semaphore qnt_clientes, Semaphore mutex, Semaphore mutex2, Fila fila,
				   Mesa mesa, String nome, int tempoBar, int tempoCasa) 
	{
		setSprite();
		sprite = new JLabel(sp2);
		sprite.setBounds(0, 530, 200, 200);

		this.numCadeiras = mesa.getNumCadeiras();
		this.fila = fila;
		this.mesa = mesa;
		this.nome = nome;
		this.bar = bar;
		bar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fundo = fundo;
		bar.remove(fundo);
		bar.add(sprite);
		SwingUtilities.updateComponentTreeUI(bar);
		bar.add(fundo);
		this.qnt_clientes = qnt_clientes;
		this.mutex = mutex;
		this.mutex2 = mutex2;
		this.tempos = new Tempos(tempoBar, tempoCasa);
	}
	
/* --------------------------------------------------------------------------------------------- */

	public void setSprite() 
	{
		sp1 = loadImage("../imagens/sprites/B4.png","Sprite 1");
		sp2 = loadImage("../imagens/sprites/B5.png","Sprite 2");
		sp3 = loadImage("../imagens/sprites/B6.png","Sprite 3");
		sp4 = loadImage("../imagens/sprites/B10.png","Sprite 4");
		sp5 = loadImage("../imagens/sprites/B11.png","Sprite 5");
		sp6 = loadImage("../imagens/sprites/B12.png","Sprite 6");
		sp7 = loadImage("../imagens/sprites/B1.png","Sprite 7");
		sp8 = loadImage("../imagens/sprites/B2.png","Sprite 8");
		sp9 = loadImage("../imagens/sprites/B3.png","Sprite 9");
		bb1 = loadImage("../imagens/sprites/B1.png", "Sprite 10");	
		bb2 = loadImage("../imagens/sprites/B3.png", "Sprite 11");	
	}
	
/* --------------------------------------------------------------------------------------------- */

	public void tomandoUma(int quantidade) 
	{
		while (quantidade != 0)
		{
			long t1, t2;
			int i = 0;
			flag = 5;
			
			t1 = System.currentTimeMillis();
			t2 = System.currentTimeMillis();
			while (i < 2) 
			{
				if (t2 - t1 > 250) 
				{
					switch (flag) 
					{
					case 5:
						sprite.setIcon(bb1);
						flag = 6;
						break;
					case 6:
						sprite.setIcon(bb2);
						flag = 5;
						break;
					}
					t1 = System.currentTimeMillis();
					i++;
				}
				t2 = System.currentTimeMillis();
			}
			quantidade--;
		}
	}
	
/* --------------------------------------------------------------------------------------------- */
	
	public void irParaCasa(int cadeira) 
	{
		long t1, t2;
		t1 = System.currentTimeMillis();
		t2 = System.currentTimeMillis();
		
		flag = 1;
		
		switch (cadeira) 
		{
			case 0:
				sprite.setLocation(1105, 535);
				
				while (sprite.getX() > 385) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() - 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp4);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp6);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				
				flag = 1;
				
				while (sprite.getY() > 365) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX(), sprite.getY() - 10);
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp7);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp9);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				break;
				
			case 1:
				sprite.setLocation(1035, 535);
				
				while (sprite.getX() > 385) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() - 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp4);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp6);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				
				flag = 1;
				
				while (sprite.getY() > 365) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX(), sprite.getY() - 10);
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp7);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp9);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				break;	
			
			case 2:
				sprite.setLocation(960, 535);
				
				while (sprite.getX() > 385) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() - 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp4);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp6);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				
				flag = 1;
				
				while (sprite.getY() > 365) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX(), sprite.getY() - 10);
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp7);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp9);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}				
				break;
			
			case 3:
				sprite.setLocation(885, 535);
				
				while (sprite.getX() > 385) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() - 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp4);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp6);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				
				flag = 1;
				
				while (sprite.getY() > 365) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX(), sprite.getY() - 10);
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp7);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp9);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}				
				break;
			
			case 4:
				sprite.setLocation(810, 535);

				while (sprite.getX() > 385) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() - 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp4);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp6);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				
				flag = 1;
				
				while (sprite.getY() > 365) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX(), sprite.getY() - 10);
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp7);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp9);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}	
				break;
			
			case 5:
				sprite.setLocation(740, 535);

				while (sprite.getX() > 385) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() - 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp4);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp6);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				
				flag = 1;
				
				while (sprite.getY() > 365) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX(), sprite.getY() - 10);
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp7);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp9);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}	
				break;
			
			case 6:
				sprite.setLocation(670, 535);

				while (sprite.getX() > 385) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() - 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp4);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp6);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				
				flag = 1;
				
				while (sprite.getY() > 365) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX(), sprite.getY() - 10);
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp7);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp9);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				break;
			
			case 7:
				sprite.setLocation(600, 535);

				while (sprite.getX() > 385) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() - 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp4);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp6);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				
				flag = 1;
				
				while (sprite.getY() > 365) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX(), sprite.getY() - 10);
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp7);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp9);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}				
				break;
			
			case 8:
				sprite.setLocation(530, 535);

				while (sprite.getX() > 385) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() - 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp4);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp6);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				
				flag = 1;
				
				while (sprite.getY() > 365) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX(), sprite.getY() - 10);
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp7);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp9);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}						
				break;
			
			case 9:
				sprite.setLocation(460, 535);

				while (sprite.getX() > 385) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() - 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp4);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp5);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp6);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				
				flag = 1;
				
				while (sprite.getY() > 365) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX(), sprite.getY() - 10);
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp7);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp8);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp9);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}			
				break;		
		}
	}
	
/* --------------------------------------------------------------------------------------------- */
	
	public void contaTempoEmCasa() 
	{
		long t1, t2;
		int i = 0;
		t1 = System.currentTimeMillis();
		t2 = System.currentTimeMillis();
		while (i < 2) 
		{
			if (t2 - t1 > 500) 
			{
				t1 = System.currentTimeMillis();
				i++;
			}
			t2 = System.currentTimeMillis();
		}
	}
	
/* --------------------------------------------------------------------------------------------- */

	public void emCasa() 
	{
		long t1, t2;
		int ressaca = 1;
		bar.remove(sprite);
		SwingUtilities.updateComponentTreeUI(bar);

		t1 = System.currentTimeMillis();
		t2 = System.currentTimeMillis();
		while (!checaTempoCasa(t2 - t1)) 
		{
			contaTempoEmCasa();
			System.out.println(nome + " ja está a " + ressaca + " segundos de ressaca.");
			ressaca++;
			t2 = System.currentTimeMillis();
		}
		
		System.out.println(nome + " se curou da ressaca, voltando para o bar.");
		fila.insereCliente(this);
		bar.remove(fundo);
		sprite.setIcon(sp2);
		flag = 1;
		sprite.setBounds(0, 530, 200, 200);
		bar.add(sprite);
		SwingUtilities.updateComponentTreeUI(bar);
		bar.add(fundo);
	}
	
/* --------------------------------------------------------------------------------------------- */

	public void run() 
	{
		long t1, t2;
		int index = 0;

		while (true) 
		{
			if (fila.inQueue(this)) 
			{
				t1 = System.currentTimeMillis();
				t2 = System.currentTimeMillis();
				try 
				{
					mutex.acquire();
					index = filaCoordenadas[fila.getIndex(this)];
					mutex.release();
				} 
				catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				while (sprite.getX() < index) 
				{
					if (t2 - t1 > 250) 
					{
						sprite.setLocation(sprite.getX() + 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp1);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp3);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				sprite.setIcon(sp2);

				if (fila.getIndex(this) == 0 && sprite.getX() == 270) 
				{
					try 
					{
						mutex2.acquire();
						bebedeira();
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
/* --------------------------------------------------------------------------------------------- */

	public void bebedeira() 
	{
		long t1, t2; 	
		int segundos = 1;

		try 
		{
			this.qnt_clientes.acquire();

			if (mesa.isBebendo()) 
			{
				System.out.println("Esperando...");
				mutex2.acquire();
			}

			t1 = System.currentTimeMillis();
			t2 = System.currentTimeMillis();

			while (sprite.getX() < 285) 
			{
				if (t2 - t1 > 250) 
				{
					sprite.setLocation(sprite.getX() + 10, sprite.getY());

					switch (flag) 
					{
						case 1:
							sprite.setIcon(sp2);
							flag++;
							break;
						case 2:
							sprite.setIcon(sp1);
							flag++;
							break;
						case 3:
							sprite.setIcon(sp2);
							flag++;
							break;
						case 4:
							sprite.setIcon(sp3);
							flag = 1;
							break;
					}
					t1 = System.currentTimeMillis();
				}
				t2 = System.currentTimeMillis();
			}
			sprite.setIcon(sp2);
			fila.removeCliente();

		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		mutex2.release();

		irParaCadeira(fila.getCadeira());

		mesa.addCliente();
		
		while (!mesa.isBebendo()) {
			System.out.println(nome + " está esperando");
		}
		
		t1 = System.currentTimeMillis();
		t2 = System.currentTimeMillis();

		while (!checaTempoBar(t2 - t1)) 
		{
			tomandoUma(2);
			System.out.println(nome + " está há " + segundos + " segundos bebendo.");
			t2 = System.currentTimeMillis();
			segundos++;
		}
		System.out.println(nome + " está bebado, voltando para casa");

		mesa.removeCliente();

		if (mesa.isVazia()) 
		{
			mutex2.release();
			fila.setCadeira(0);
		}
		this.qnt_clientes.release();

		irParaCasa(fila.getCadeira());

		emCasa();
	}
	
/* --------------------------------------------------------------------------------------------- */

	private boolean checaTempoBar(long tempo) {
		return tempo >= tempos.getTempoBar();
	}
	
/* --------------------------------------------------------------------------------------------- */

	private boolean checaTempoCasa(long tempo) {
		return tempo >= tempos.getTempoCasa();
	}
	
/* --------------------------------------------------------------------------------------------- */

	public String getNome() {
		return this.nome;
	}
	
/* --------------------------------------------------------------------------------------------- */

	public void irParaCadeira(int cadeira) 
	{
		long t1, t2;
		t1 = System.currentTimeMillis();
		t2 = System.currentTimeMillis();
		
		switch (cadeira) 
		{
			case 0:
				fila.setCadeira(1);

				while (sprite.getX() < 1105) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() + 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp1);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp3);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				sprite.setLocation(1105, 380);
				
				break;
				
			case 1:
				fila.setCadeira(2);

				while (sprite.getX() < 1035) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() + 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp1);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp3);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				sprite.setLocation(1035, 380);
				
				break;				
			
			case 2:
				fila.setCadeira(3);

				while (sprite.getX() < 960) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() + 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp1);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp3);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				sprite.setLocation(960, 380);
				
				break;
			
			case 3:
				fila.setCadeira(4);

				while (sprite.getX() < 885) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() + 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp1);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp3);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				sprite.setLocation(885, 380);
				
				break;
			
			case 4:
				fila.setCadeira(5);

				while (sprite.getX() < 810) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() + 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp1);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp3);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				sprite.setLocation(810, 380);
	
				break;
			
			case 5:
				fila.setCadeira(6);

				while (sprite.getX() < 740) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() + 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp1);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp3);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				sprite.setLocation(740, 380);
	
				break;
			
			case 6:
				fila.setCadeira(7);

				while (sprite.getX() < 670) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() + 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp1);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp3);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				sprite.setLocation(670, 380);

				break;
			
			case 7:
				fila.setCadeira(8);
				
				while (sprite.getX() < 600) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() + 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp1);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp3);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}	
				sprite.setLocation(600, 380);
				
				break;
			
			case 8:
				fila.setCadeira(9);

				while (sprite.getX() < 530) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() + 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp1);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp3);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}				
				sprite.setLocation(530, 380);
				
				break;
			
			case 9:
				fila.setCadeira(10);

				while (sprite.getX() < 460) 
				{
					if (t2 - t1 > 150) 
					{
						sprite.setLocation(sprite.getX() + 10, sprite.getY());
						switch (flag) 
						{
							case 1:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 2:
								sprite.setIcon(sp1);
								flag++;
								break;
							case 3:
								sprite.setIcon(sp2);
								flag++;
								break;
							case 4:
								sprite.setIcon(sp3);
								flag = 1;
								break;
						}
						t1 = System.currentTimeMillis();
					}
					t2 = System.currentTimeMillis();
				}
				sprite.setLocation(460, 380);
	
				break;	
		}
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
