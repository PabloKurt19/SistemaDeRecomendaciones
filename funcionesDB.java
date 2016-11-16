
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
   
private GraphDatabaseService graphDb;
private Vector<String> profesores;


      
    public void Conectar(){
    	
         File rute = new File ("C:\\Users\\usuario\\Documents\\Neo4j\\PruebaProyecto3");
    	 graphDb= new GraphDatabaseFactory().newEmbeddedDatabase( rute );
         registerShutdownHook(graphDb);
         profesores = new Vector();
         
		 
    }
    
    public enum NodeType implements Label{
        catedratico,especialidad,curso;
    }
    
    public enum RelationType implements RelationshipType{
        orientada_a,Orienta;
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

public void apagar(){
	graphDb.shutdown();
}

 } 
    
 
