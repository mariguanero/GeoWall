package geowallgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class ActorFondo extends Actor implements Disposable {
	private Texture fondo;
	private TextureRegion mifondo;
	private int valory=Gdx.graphics.getHeight();
	private int valor=0;
	
	public ActorFondo(){
		valor= (int)(Math.random()*10);
		//Para cargar una textura de la carpeta Asses
		int nAle= (int) Math.random()*14;
		fondo = new Texture(nAle+".png");
		mifondo = new TextureRegion(fondo);	
		mifondo.setRegionWidth(Gdx.graphics.getWidth());
		int tamanow=fondo.getWidth();		
		int tamanoh=fondo.getHeight();
		setSize(tamanow,tamanoh );		
	}
	public ActorFondo(String muro){		
		fondo = new Texture("muro.jpg");
		mifondo = new TextureRegion(fondo);		
		int tamanow=Gdx.graphics.getWidth();
		int tamanoh=Gdx.graphics.getHeight();
		setSize(tamanow,tamanoh );
	}
	
	public ActorFondo(int valor){
		this.valor= (int)(Math.random()*valor);
		fondo = new Texture(this.valor+".png");
		mifondo = new TextureRegion(fondo);		
		int tamanow=fondo.getWidth();
		int tamanoh=fondo.getHeight();
		setSize(tamanow,tamanoh );
		
	}
	


	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		Color col = getColor();
		batch.setColor(col.r, col.g, col.b, col.a*parentAlpha);		
		batch.draw(mifondo, getCenterX(), valory, 0, 0, getWidth() ,
				getHeight(), getScaleX(), getScaleY(), getRotation());						
	}


	public Texture getFondo() {
		return fondo;
	}

	public void setFondo(Texture fondo) {
		this.fondo = fondo;
	}

	public int getValory() {
		return valory;
	}

	public void setValory(int valory) {
		this.valory = valory;
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
		fondo.dispose();
		
	}



	public Texture getfondo() {
		return fondo;
	}



	public void setfondo(Texture fondo) {
		this.fondo = fondo;
	}



	public TextureRegion getMifondo() {
		return mifondo;
	}



	public void setMifondo(TextureRegion mifondo) {
		this.mifondo = mifondo;
	}
	
}