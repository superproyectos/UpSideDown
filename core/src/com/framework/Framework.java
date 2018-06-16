package com.framework;

import com.badlogic.gdx.ApplicationAdapter;

public class Framework extends ApplicationAdapter
{
	/*final float PPM =100;
	private boolean debug;
	PolygonSprite poly,seg;
	PolygonSpriteBatch polyBatch;
	Texture textureSolid;
	public static World mundo;
	Body algg;
	ShapeRenderer sss;
	Square cuadrado;
	Grupo grupo;
	Circulo cir;
	Sprite sprite;
	Batch batch;
	Camara camaras;
	float a[]={2,2,3,2, 3, 1, 2, 1,3,1,4,1,4,2,3,2};

	float b[]={200, 200,300, 200, 300, 100, 200, 100};
	float c[]={0, 0,2.2f, 0,0, 0.5f, 2.2f, 0.5f};
	@Override
	public void create ()
	{
		Camara.setPPM(PPM);
		camaras=new Camara();
		mundo= Mundo.MUNDO;

		mundo.setGravity(new Vector2(0,-5));
		createPhysicsObjectFromGraphics(c,new Vector2(0,0),BodyDef.BodyType.StaticBody);
		cuadrado=new Square(350,150,100,Colores.MORADO);
		grupo=new GrupoFisico(
		        new Square(250,400,100,Colores.AMARILLO),
				new Pentagon(350,400,50,Colores.AZUL),
		        new Hexagono(250,300,50,Colores.NARANJA),
                new Heptagon(150,400,50,Colores.TURQUESA));

		((GrupoFisico) grupo).setDensidad(1);
		((GrupoFisico) grupo).setRebote(1);
		((GrupoFisico) grupo).setTipoCuerpo(new CuerpoEstatico());
		cir=new CirculoFisico(100,450,30);
		((CirculoFisico) cir).setDensidad(15);
		sprite=new Sprite(new Square(250,100,100,Colores.AMARILLO).getRelleno().getTextura()); //Used for drawing 2D sprites.
	    batch=new SpriteBatch();
	}

	@Override
	public void render ()
	{
		mundo.step(Gdx.graphics.getDeltaTime(), 8, 3);
        Gdx.gl.glClearColor(120/255f, 40/255f, 150/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		/*polyBatch.begin();
		poly.draw(polyBatch);
		polyBatch.end();
		//poly.setOrigin(poly.getX(),poly.getY());
		poly.setRotation((float)Math.toDegrees(algg.getAngle()));
		poly.setPosition(algg.getPosition().x*PPM,algg.getPosition().y*PPM);
		sss.begin(ShapeRenderer.ShapeType.Filled);
			sss.circle(poly.getOriginX(),poly.getOriginY(),5);
		sss.end();
		cuadrado.setRotacion((float)Math.toDegrees(algg.getAngle()));
	cuadrado.setPosicion(algg.getPosition().x*PPM,algg.getPosition().y*PPM);
		cuadrado.dibujar();
		//poly.rotate(1.1f);
		Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
        //camaraBordes.render(mundo,camara.combined);
		camaras.modoDebug(mundo);
        grupo.dibujar();
        cir.dibujar();
		batch.begin();
			sprite.draw(batch);
		batch.end();
	}
	private Body createPhysicsObjectFromGraphics(float a[], Vector2 position, BodyDef.BodyType bodyType)
	{
		BodyDef boxBodyDef = new BodyDef();
		boxBodyDef.type = bodyType;
		boxBodyDef.position.x = position.x/PPM;
		boxBodyDef.position.y = position.y/PPM;
		Body boxBody = mundo.createBody(boxBodyDef);
		PolygonShape boxPoly = new PolygonShape();
		boxPoly.set(a);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = boxPoly;
		fixtureDef.density=1;
		fixtureDef.restitution=0.2f;
		boxBody.createFixture(fixtureDef);

		boxPoly.dispose();
		boxBody.setUserData("as");
		return boxBody;
	}
	@Override
	public void dispose () {

	}*/
}
