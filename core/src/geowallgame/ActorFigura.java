package geowallgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class ActorFigura extends Actor implements Disposable {
	private Texture figura;
	private TextureRegion mifigura;
	private int contador=0;
	private int valor;
	
	public ActorFigura(){
		//Para cargar una textura de la carpeta Asses
		//String varayuda= (int)(Math.random()*14)+".png";
		//System.out.println(varayuda);
		this.valor=contador;
		figura = new Texture(contador+".png");
		//contador ++;
		mifigura = new TextureRegion(figura);		
		int tamanow=figura.getWidth();
		int tamanoh=figura.getHeight();
		mifigura.setRegionWidth(tamanow);
		mifigura.setRegionHeight(tamanoh);
	}
	
	public ActorFigura(int valor){
		this.valor = valor;
		figura = new Texture(valor+".png");
		mifigura = new TextureRegion(figura);		
		int tamanow=figura.getWidth();
		int tamanoh=figura.getHeight();
		//mifigura.setRegionWidth(tamanow);
		//mifigura.setRegionHeight(tamanoh);
		setSize(tamanow,tamanoh );
	}
	


	@Override
	public void draw(Batch batch, float parentAlpha) {
		Color col = getColor();
		batch.setColor(col.r, col.g, col.b, col.a*parentAlpha);		
		batch.draw(mifigura, getCenterX(), 0, 0, 0, getWidth() , getHeight(), getScaleX(), getScaleY(), getRotation());
		//batch.draw(mifigura, getCenterX(), getCenterY());
		
		
		
		/*contador++;
		if(contador>15){
			contador=1;
		}
	*/
	}


	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		super.clear();
	}

	@Override
	public void dispose(){
		figura.dispose();
		
	}



	public Texture getFigura() {
		return figura;
	}



	public void setFigura(Texture figura) {
		this.figura = figura;
	}



	public TextureRegion getMifigura() {
		return mifigura;
	}



	public void setMifigura(TextureRegion mifigura) {
		this.mifigura = mifigura;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
