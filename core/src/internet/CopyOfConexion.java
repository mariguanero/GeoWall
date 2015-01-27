package internet;

//import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.majiba.geowall.GeoWallPrin;
import com.majiba.geowall.Pantalla;
import com.majiba.geowall.Usuario;



public class CopyOfConexion extends Pantalla implements HttpResponseListener{

	
	BitmapFont font;
	SpriteBatch batch;
	String url, mensaje="Registrando Puntaje.. espere";
	String httpMethod = Net.HttpMethods.GET;
	String solicitud_variables = null;
	HttpRequest httpsolicitud;
	String varayuda;
	
	

	public CopyOfConexion(GeoWallPrin game, Usuario user) {
		super(game, user);
		// TODO Auto-generated constructor stub
	}


	
	public void show () {
		System.out.println("Llega a Conexion");
		batch = new SpriteBatch();
		font = new BitmapFont();
		url = "http://www.tuweb.com/index.php?";
		solicitud_variables = "&nombre=suscribete&puntaje=222";
		httpsolicitud = new HttpRequest(httpMethod);
		httpsolicitud.setUrl(url);
		//httpsolicitud.setContent(solicitud_variables);
		Gdx.net.sendHttpRequest(httpsolicitud, CopyOfConexion.this);
	}
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, mensaje, 10, 50);
		batch.end();
	}
	
	@Override
	public void handleHttpResponse(HttpResponse httpResponse) {
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run () {
				System.out.println("HTTP Procesado con exito :D ");
			}
		});
	}
	
	@Override
	public void failed(Throwable t) {
	}

	@Override
	public void cancelled() {
	}
}
