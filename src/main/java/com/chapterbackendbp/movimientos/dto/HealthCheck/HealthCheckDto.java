package com.chapterbackendbp.movimientos.dto.HealthCheck;


public class HealthCheckDto {
    
    private boolean esAplicacionActivo;

    public boolean getAplicacionActivo() {
        return esAplicacionActivo;
    }

    public void setAplicacionActivo(boolean esAplicacionActivo) {
        this.esAplicacionActivo = esAplicacionActivo;
    }
}
