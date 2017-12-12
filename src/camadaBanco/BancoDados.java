package camadabanco;

import java.sql.Connection;
import java.sql.DriverManager;



// para que n�o possa ser instanciado a classe deve ser final 
//e n�o permitir que exista mais de uma banco de dados
public final class BancoDados {

	public static Connection conexao;
	
	private BancoDados(){
		
	}	
	@SuppressWarnings("finally")
	public static Connection abreConexao() throws ClassNotFoundException{
            Class.forName("com.mysql.jdbc.Driver");
		try{
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/rpg?useSSL=false", "root", "batata");
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return conexao;
		}
		
	}
	
	public static void fechaConexao(){
		if(conexao != null){
			try{
				conexao.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	
}

