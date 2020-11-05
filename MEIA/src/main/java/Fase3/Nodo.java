/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fase3;

/**
 *
 * @author roche
 */
public class Nodo 
{
    public int NoRegistro;
        public int Hash;
    public Nodo izq;
    public Nodo der;
    public String Usuario;
   public  String Path;
    public String FechaTransaccion;
    public boolean Status;
    
    
    
    public int CalcularValor()
    {
        int hashito =0;
        for (int i = 0; i < this.Usuario.length(); i++) {
            hashito += (int)(byte)this.Usuario.charAt(i);
        }   
         for (int i = 0; i < this.Path.length(); i++) {
            hashito += (int)(byte)this.Path.charAt(i);
        }
         this.Hash = hashito;
        return hashito;
    }
    public String Stringer()
    {
        var salida ="";
        
        salida += this.NoRegistro+"|";
        
        try {
            salida +=String.valueOf(this.izq.NoRegistro);
        } catch (Exception e) {
            salida +="-1";
        }
        
                salida +="|";
         try {
            salida +=String.valueOf(this.der.NoRegistro);
        } catch (Exception e) {
            salida +="-1";
        }
             
               salida +="|"+this.Usuario+"|"+
                this.FechaTransaccion+"|"+((this.Status) ? "1" : "0");

        return salida;
    }
    
}
