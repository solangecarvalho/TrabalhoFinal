package br.univel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DownloadTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		RendererComum rendererComum = new RendererComum();
		ProgressRenderer pr = new ProgressRenderer();
		table = new JTable(){

			
			@Override
			public TableCellRenderer getCellRenderer(int arg0, int arg1) {
				if (arg1 == 1)					
					return pr;
				else
					return super.getCellRenderer(arg0, arg1);
			}
			
		};
		modelo = new DownloadTableModel();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {			
			
			public void actionPerformed(ActionEvent arg0) {		
				carregar();
			}
		});		
		
		contentPane.add(btnAdicionar, BorderLayout.NORTH);			
		
	}
	
	
	

	protected void carregar() {		
		
		
		Pessoa p = new Pessoa();
		p.setNome("");
		p.setId(1);
		
		
		
		modelo.addNovoDownload(p);
		
		
		
	}
	

}
