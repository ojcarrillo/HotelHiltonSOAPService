
package org.example.demo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idReserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idHabitacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaIngreso" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="fechaSalida" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="ciudad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hotel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="habitacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="motivoEstado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaRespuesta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="codigoEstado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idReserva",
    "idHabitacion",
    "fechaIngreso",
    "fechaSalida",
    "ciudad",
    "hotel",
    "habitacion",
    "estado",
    "motivoEstado",
    "fechaRespuesta",
    "codigoEstado"
})
@XmlRootElement(name = "obtenerReservaResponse")
public class ObtenerReservaResponse {

    protected String idReserva;
    protected String idHabitacion;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaIngreso;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaSalida;
    protected String ciudad;
    protected String hotel;
    protected String habitacion;
    protected String estado;
    protected String motivoEstado;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRespuesta;
    protected String codigoEstado;

    /**
     * Obtiene el valor de la propiedad idReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdReserva() {
        return idReserva;
    }

    /**
     * Define el valor de la propiedad idReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdReserva(String value) {
        this.idReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad idHabitacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdHabitacion() {
        return idHabitacion;
    }

    /**
     * Define el valor de la propiedad idHabitacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdHabitacion(String value) {
        this.idHabitacion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaIngreso.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Define el valor de la propiedad fechaIngreso.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaIngreso(XMLGregorianCalendar value) {
        this.fechaIngreso = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSalida.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Define el valor de la propiedad fechaSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaSalida(XMLGregorianCalendar value) {
        this.fechaSalida = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Define el valor de la propiedad ciudad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudad(String value) {
        this.ciudad = value;
    }

    /**
     * Obtiene el valor de la propiedad hotel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * Define el valor de la propiedad hotel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotel(String value) {
        this.hotel = value;
    }

    /**
     * Obtiene el valor de la propiedad habitacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHabitacion() {
        return habitacion;
    }

    /**
     * Define el valor de la propiedad habitacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHabitacion(String value) {
        this.habitacion = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad motivoEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivoEstado() {
        return motivoEstado;
    }

    /**
     * Define el valor de la propiedad motivoEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivoEstado(String value) {
        this.motivoEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaRespuesta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaRespuesta() {
        return fechaRespuesta;
    }

    /**
     * Define el valor de la propiedad fechaRespuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaRespuesta(XMLGregorianCalendar value) {
        this.fechaRespuesta = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoEstado() {
        return codigoEstado;
    }

    /**
     * Define el valor de la propiedad codigoEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoEstado(String value) {
        this.codigoEstado = value;
    }

}
