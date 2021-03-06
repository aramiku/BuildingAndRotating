package com.saiko.geobraxlogorotation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class DrawView extends View {
    Paint paint = new Paint();
    Face[] fcs = new Face[6000];
    Ponto3D[] pointsins = new Ponto3D[8000];
    Double xini = 1.0;
    Double yini = 1.0;
    Double xfin = 1.0;
    Double yfin = 1.0;
    int f = 29;
    int scalex = 25;
    Double xaux = 2.5; // Dir / Esq  , aumenta vai para dir
    Double yaux = 1.0; // pcima / pbaixo , diminui vai para cima ???
    Double zaux = 2.0;
    int facenumber = 2241;
    

    public DrawView(Context context,Face[] fcspass,Ponto3D[] ptspass) {
        super(context);
        this.fcs = fcspass;
        this.pointsins = ptspass;
        paint.setColor(Color.BLACK);
        Log.d("DrawView","terminou o construtor.");
    }

    @Override
    public void onDraw(Canvas canvas) {
    	Log.d("DrawView","dentro de onDraw");
		double[] olho = {200, 140, 150};

		Random rnd = new Random();
		int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
		paint.setColor(color);
		//canvas.drawLine(800,200, 400,  400, paint);
    		// depois de transformado os pontos 3D em 2D , abaixo desenha as linhas do cubo
    	for(int i=1; i<facenumber; i++){
			Log.d("Dentro de for", "dentrodeforrooo");
			Log.d("verticNum", String.valueOf(fcs[i].verticesNumber));
    		if(fcs[i].verticesNumber == 4){

    			//Log.d("DrawView","dentro de for , if z= "+Double.toString(pointsins[fcs[i].pto1].z)+" x = " + Double.toString(pointsins[fcs[i].pto1].x) + " y =" + Double.toString(pointsins[fcs[i].pto1].y));
    			xini = ((f/(pointsins[fcs[i].pto1].z+zaux))*(pointsins[fcs[i].pto1].x+xaux))*scalex;
    			yini = ((f/(pointsins[fcs[i].pto1].z+zaux))*(pointsins[fcs[i].pto1].y+yaux))*scalex;
    			xfin = ((f/(pointsins[fcs[i].pto2].z+zaux))*(pointsins[fcs[i].pto2].x+xaux))*scalex;
    			yfin = ((f/(pointsins[fcs[i].pto2].z+zaux))*(pointsins[fcs[i].pto2].y+yaux))*scalex;
    			/*xini = ((olho[2] * (pointsins[fcs[i].pto1].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto1].zt) + olho[0])*f;
    			yini = ((olho[2] * (pointsins[fcs[i].pto1].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto1].zt) + olho[1])*f;
    			xfin = ((olho[2] * (pointsins[fcs[i].pto2].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto2].zt) + olho[0])*f;
    			yfin = ((olho[2] * (pointsins[fcs[i].pto2].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto2].zt) + olho[1])*f;*/
    			if(xini > 0 && yini > 0 && xfin > 0 && yfin > 0){
    				Log.d("Drawline1","xini : " + xini + "    yini : " + yini + "     xfin : " + xfin + "    yfin : " + yfin);
    				canvas.drawLine(Math.round(xini),Math.round(yini), Math.round(xfin),  Math.round(yfin), paint);
    			}else{
    				Log.d("MarandMis","pontosdeung");
					Log.d("Drawline3","xini : " + xini + "    yini : " + yini + "     xfin : " + xfin + "    yfin : " + yfin);
				}
    			xini = ((f/(pointsins[fcs[i].pto2].z+zaux))*(pointsins[fcs[i].pto2].x+xaux))*scalex;
    			yini = ((f/(pointsins[fcs[i].pto2].z+zaux))*(pointsins[fcs[i].pto2].y+yaux))*scalex;
    			xfin = ((f/(pointsins[fcs[i].pto3].z+zaux))*(pointsins[fcs[i].pto3].x+xaux))*scalex;
    			yfin = ((f/(pointsins[fcs[i].pto3].z+zaux))*(pointsins[fcs[i].pto3].y+yaux))*scalex;
    			/*xini = ((olho[2] * (pointsins[fcs[i].pto2].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto2].zt) + olho[0])*f;
    			yini = ((olho[2] * (pointsins[fcs[i].pto2].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto2].zt) + olho[1])*f;
    			xfin = ((olho[2] * (pointsins[fcs[i].pto3].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto3].zt) + olho[0])*f;
    			yfin = ((olho[2] * (pointsins[fcs[i].pto3].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto3].zt) + olho[1])*f;*/
    			if(xini > 0 && yini > 0 && xfin > 0 && yfin > 0){
    				canvas.drawLine(Math.round(xini),Math.round(yini), Math.round(xfin),  Math.round(yfin), paint);
					Log.d("Drawline2","xini : " + xini + "    yini : " + yini + "     xfin : " + xfin + "    yfin : " + yfin);
    			}else{
					Log.d("MarandMis","pontosdeung");
					Log.d("Drawline3","xini : " + xini + "    yini : " + yini + "     xfin : " + xfin + "    yfin : " + yfin);
				}
    			xini = ((f/(pointsins[fcs[i].pto3].z+zaux))*(pointsins[fcs[i].pto3].x+xaux))*scalex;
    			yini = ((f/(pointsins[fcs[i].pto3].z+zaux))*(pointsins[fcs[i].pto3].y+yaux))*scalex;
    			xfin = ((f/(pointsins[fcs[i].pto4].z+zaux))*(pointsins[fcs[i].pto4].x+xaux))*scalex;
    			yfin = ((f/(pointsins[fcs[i].pto4].z+zaux))*(pointsins[fcs[i].pto4].y+yaux))*scalex;
    			/*xini = ((olho[2] * (pointsins[fcs[i].pto3].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto3].zt) + olho[0])*f;
    			yini = ((olho[2] * (pointsins[fcs[i].pto3].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto3].zt) + olho[1])*f;
    			xfin = ((olho[2] * (pointsins[fcs[i].pto4].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto4].zt) + olho[0])*f;
    			yfin = ((olho[2] * (pointsins[fcs[i].pto4].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto4].zt) + olho[1])*f;*/
    			if(xini > 0 && yini > 0 && xfin > 0 && yfin > 0){
    				canvas.drawLine(Math.round(xini),Math.round(yini), Math.round(xfin),  Math.round(yfin), paint);
					Log.d("Drawline3","xini : " + xini + "    yini : " + yini + "     xfin : " + xfin + "    yfin : " + yfin);
    			}else{
					Log.d("MarandMis","pontosdeung");
					Log.d("Drawline3","xini : " + xini + "    yini : " + yini + "     xfin : " + xfin + "    yfin : " + yfin);
				}
    			// nao precisa desenhar esta linha, como esta desenhando
    			// quadrado, entao se desenhar um parte do quadrado
    			// o pr�ximo quadrado ir� terminar o quadrado anterior.
    			/*xini = (f/pointsins[fcs[i].pto4].zt)*pointsins[fcs[i].pto4].xt;
    			yini = (f/pointsins[fcs[i].pto4].zt)*pointsins[fcs[i].pto4].yt;
    			xfin = (f/pointsins[fcs[i].pto1].zt)*pointsins[fcs[i].pto1].xt;
    			yfin = (f/pointsins[fcs[i].pto1].zt)*pointsins[fcs[i].pto1].yt;*/

				/*xini = ((olho[2] * (pointsins[fcs[i].pto4].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto4].zt) + olho[0])*f;
				yini = ((olho[2] * (pointsins[fcs[i].pto4].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto4].zt) + olho[1])*f;
				xfin = ((olho[2] * (pointsins[fcs[i].pto1].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto1].zt) + olho[0])*f;
				yfin = ((olho[2] * (pointsins[fcs[i].pto1].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto1].zt) + olho[1])*f;

				if(xini > 0 && yini > 0 && xfin > 0 && yfin > 0){
    				canvas.drawLine(Math.round(xini),Math.round(yini), Math.round(xfin),  Math.round(yfin), paint);
    			}*/
    		}

    	}


 

            
    }

	public void giraCuboXGraus2(Double g){
		
		// pega cada face com 4 vertices , e faz a transla��o / rota��o

    	for(int i=1; i<facenumber; i++){
    		if(fcs[i].verticesNumber == 4){
    			Log.d("giraCuboXGraus g= "+ Double.toString(g)," , if z= "+Double.toString(pointsins[fcs[i].pto1].z)+" x = " + Double.toString(pointsins[fcs[i].pto1].x) + " y =" + Double.toString(pointsins[fcs[i].pto1].y));
    			
    			// move ponto para origem dos quatro vertices da face
    			/*pointsins[fcs[i].pto1].x = pointsins[fcs[i].pto1].x - xaux;
    			pointsins[fcs[i].pto1].y = pointsins[fcs[i].pto1].y - yaux;
    			pointsins[fcs[i].pto1].z = pointsins[fcs[i].pto1].z - zaux;
    			
    			pointsins[fcs[i].pto2].x = pointsins[fcs[i].pto2].x - xaux;
    			pointsins[fcs[i].pto2].y = pointsins[fcs[i].pto2].y - yaux;
    			pointsins[fcs[i].pto2].z = pointsins[fcs[i].pto2].z - zaux;
    			
    			pointsins[fcs[i].pto3].x = pointsins[fcs[i].pto3].x - xaux;
    			pointsins[fcs[i].pto3].y = pointsins[fcs[i].pto3].y - yaux;
    			pointsins[fcs[i].pto3].z = pointsins[fcs[i].pto3].z - zaux;
    			
    			pointsins[fcs[i].pto4].x = pointsins[fcs[i].pto4].x - xaux;
    			pointsins[fcs[i].pto4].y = pointsins[fcs[i].pto4].y - yaux;
    			pointsins[fcs[i].pto4].z = pointsins[fcs[i].pto4].z - zaux;*/



    			// faz rota��o
    			pointsins[fcs[i].pto1].xt = (pointsins[fcs[i].pto1].x * Math.cos(Math.toRadians(g))) +  (pointsins[fcs[i].pto1].z * Math.sin(Math.toRadians(g)));
    			pointsins[fcs[i].pto2].xt = (pointsins[fcs[i].pto2].x * Math.cos(Math.toRadians(g))) +  (pointsins[fcs[i].pto2].z * Math.sin(Math.toRadians(g)));
    			pointsins[fcs[i].pto3].xt = (pointsins[fcs[i].pto3].x * Math.cos(Math.toRadians(g))) +  (pointsins[fcs[i].pto3].z * Math.sin(Math.toRadians(g)));
    			pointsins[fcs[i].pto4].xt = (pointsins[fcs[i].pto4].x * Math.cos(Math.toRadians(g))) +  (pointsins[fcs[i].pto4].z * Math.sin(Math.toRadians(g)));
    			
    			
    			pointsins[fcs[i].pto1].yt =  pointsins[fcs[i].pto1].y  ;
    			pointsins[fcs[i].pto2].yt =  pointsins[fcs[i].pto2].y  ;
    			pointsins[fcs[i].pto3].yt =  pointsins[fcs[i].pto3].y  ;
    			pointsins[fcs[i].pto4].yt =  pointsins[fcs[i].pto4].y  ;
    			
    			
    			pointsins[fcs[i].pto1].zt = (pointsins[fcs[i].pto1].z * Math.cos(Math.toRadians(g))) - (pointsins[fcs[i].pto1].x * Math.sin(Math.toRadians(g))) ;
    			pointsins[fcs[i].pto2].zt = (pointsins[fcs[i].pto2].z * Math.cos(Math.toRadians(g))) - (pointsins[fcs[i].pto2].x * Math.sin(Math.toRadians(g))) ;
    			pointsins[fcs[i].pto3].zt = (pointsins[fcs[i].pto3].z * Math.cos(Math.toRadians(g))) - (pointsins[fcs[i].pto3].x * Math.sin(Math.toRadians(g))) ;
    			pointsins[fcs[i].pto4].zt = (pointsins[fcs[i].pto4].z * Math.cos(Math.toRadians(g))) - (pointsins[fcs[i].pto4].x * Math.sin(Math.toRadians(g))) ;






    			// Coloca nos pontos do próprio objeto
    			pointsins[fcs[i].pto1].x = pointsins[fcs[i].pto1].xt ;
    			pointsins[fcs[i].pto1].y = pointsins[fcs[i].pto1].yt ;
    			pointsins[fcs[i].pto1].z = pointsins[fcs[i].pto1].zt ;
    			
    			pointsins[fcs[i].pto2].x = pointsins[fcs[i].pto2].xt ;
    			pointsins[fcs[i].pto2].y = pointsins[fcs[i].pto2].yt ;
    			pointsins[fcs[i].pto2].z = pointsins[fcs[i].pto2].zt ;
    			
    			pointsins[fcs[i].pto3].x = pointsins[fcs[i].pto3].xt ;
    			pointsins[fcs[i].pto3].y = pointsins[fcs[i].pto3].yt ;
    			pointsins[fcs[i].pto3].z = pointsins[fcs[i].pto3].zt ;
    			
    			pointsins[fcs[i].pto4].x = pointsins[fcs[i].pto4].xt ;
    			pointsins[fcs[i].pto4].y = pointsins[fcs[i].pto4].yt ;
    			pointsins[fcs[i].pto4].z = pointsins[fcs[i].pto4].zt ;
    			
    			// retorna tamb�m os xts para origem
    			/*pointsins[fcs[i].pto1].x = pointsins[fcs[i].pto1].xt ;
    			pointsins[fcs[i].pto1].y = pointsins[fcs[i].pto1].yt ;
    			pointsins[fcs[i].pto1].z = pointsins[fcs[i].pto1].zt ;
    			
    			pointsins[fcs[i].pto2].x = pointsins[fcs[i].pto2].xt ;
    			pointsins[fcs[i].pto2].y = pointsins[fcs[i].pto2].yt ;
    			pointsins[fcs[i].pto2].z = pointsins[fcs[i].pto2].zt ;
    			
    			pointsins[fcs[i].pto3].x = pointsins[fcs[i].pto3].xt ;
    			pointsins[fcs[i].pto3].y = pointsins[fcs[i].pto3].yt ;
    			pointsins[fcs[i].pto3].z = pointsins[fcs[i].pto3].zt ;
    			
    			pointsins[fcs[i].pto4].x = pointsins[fcs[i].pto4].xt ;
    			pointsins[fcs[i].pto4].y = pointsins[fcs[i].pto4].yt ;
    			pointsins[fcs[i].pto4].z = pointsins[fcs[i].pto4].zt ;*/
    		}
    	}

	}
    


}