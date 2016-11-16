/**
 *Permite la conexión con la base de datos en Neo4j y contiene los métodos de busqueda para recomendaciones
 */

/**
 * @author Pablo Ortiz, Pedro Garcia, Hugo Elvira, Edgar Ramirez
 * @version 16.11.16
 */
import java.io.File;

import java.util.HashSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.factory.*;

public class funcionesDB {
	
	/**
	 * atributos
	 */
   
private GraphDatabaseService graphDb;
private Vector<String> profesores;
private Vector<String> clubs;

/**
 * Método que permite la conexión con la BD en Neo4j
 * @param nothgin
 * @return nothing
 */
    public void Conectar(){
    	
         File rute = new File ("C:\\Users\\usuario\\Documents\\Neo4j\\PruebaProyecto3");
    	 graphDb= new GraphDatabaseFactory().newEmbeddedDatabase( rute );
         registerShutdownHook(graphDb);
         profesores = new Vector();
         
		 
    }
    
    public enum NodeType implements Label{
        catedratico,especialidad,curso,Intereses;
    }
    
    public enum RelationType implements RelationshipType{
        orientada_a,Orienta,ES_UN_CLUB;
    }
    
   
    private static void registerShutdownHook (final GraphDatabaseService graphDb){
    	Runtime.getRuntime().addShutdownHook(new Thread()
    			{
    		
    				@Override
    				public void run(){
    					graphDb.shutdown();
    				}
    			}
    			
    			
    			);
    	
    }
    /**
     * Método que realiza la busqueda de los clubs de acuerdo a sus intereses
     * @param String interes
     * @return Vector <String> clubs
     */
public Vector getClub(String interes){
	clubs = new Vector();
	clubs.clear();
	
	try (Transaction tx = graphDb.beginTx()) {
		
    	ResourceIterator<Node> posibles = graphDb.findNodes(NodeType.Intereses);
    	Iterable<Relationship> relation;
		while (posibles.hasNext()){
		 Node club = posibles.next();
		 if(club.getProperty("name").equals(interes)){
			 for( Relationship relationship : club.getRelationships( Direction.INCOMING,
				     RelationType.ES_UN_CLUB ) ){
				 profesores.add( ( String )relationship.getOtherNode(club)
	                        .getProperty( "name" ) );

			 }
			
		 }
		 
		
		} 
          
          
  		tx.success();
  	}
	return clubs;
}

/**
 * Método que realiza la busqueda de catedraticos de acuerdo con el curso y su enfoque
 * @param String enfoque
 * @return Vector <String> profesores
 */
    
public Vector getRecomendation(String enfoque){
	
		profesores = new Vector();
		profesores.clear();
    	//Vector<String> names = new Vector();
    	//Node genre =graphDb.findNode(NodeType.Genre,"Name",genero);
    	try (Transaction tx = graphDb.beginTx()) {
    		
        	ResourceIterator<Node> candidatos = graphDb.findNodes(NodeType.especialidad);
        	Iterable<Relationship> relation;
    		while (candidatos.hasNext()){
    		 Node genre = candidatos.next();
    		 if(genre.getProperty("name").equals(enfoque)){
    			 for( Relationship relationship : genre.getRelationships( Direction.INCOMING,
    				     RelationType.Orienta ) ){
    				 profesores.add( ( String )relationship.getOtherNode( genre)
    	                        .getProperty( "name" ) );

    			 }
    			
    		 }
    		 
    		
    		} 
              
              
      		tx.success();
      	}
    	return profesores;
}

/**
 * Método que cierra la sesión con la base de datos
 * @param nothing
 * @return nothing
 */

public void apagar(){
	graphDb.shutdown();
}

 } 
    
 
