<% request.setCharacterEncoding("UTF-8"); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        
        <div class="div_buscarEstu">
            <div class="div_banner">Buscar Usuarios</div>
            <div class="div_busqueda">
 
          <!--  <div class="btn">
                <i class="fas fa-search icon"></i>
            </div> -->
          <select id="usuario" onchange="tipoUsuarios(this.value)">
              <option disabled selected>Tipo de Usuario</option>
              <option value="1">DOCENTE</option>
              <option value="2">ESTUDIANTE</option>
          </select>
          
          <select id="grados" onchange="obtenerUsuarios(this.value)" hidden>
            
            <option disabled selected>Grado</option>
            <option value="1">Noveno</option>
            <option value="2">Decimo</option>
            <option value="3">Once</option>
        </select>&nbsp;&nbsp;
        
      
        <select id="usuarios" name="nomEstu" style="width: 380px;" hidden>
       
          </select>    
    
     
        <button type="button" onclick="obtenerInfoUser($('#usuarios').val(),$('#grados').val(),$('#usuario').val())" style="float: none;" >Buscar &nbsp;<img style="width: 20px; height: 20px;" src="Styles/Icons/search.png" alt="alt"/></button>

             </div>
        
            <div class="div_rBusqueda">
            
            <table class="table">
                <thead>
                <th>Nombre</th>
                <th>Documento Identidad</th>                  
                <th>Ver</th>
                </thead>
                
                <tbody id="rows_est">
                   
                </tbody>
                
                
            </table>
            
            </div>
        </div>


<div class="modal_fondo">
    <div class="div_modal">
          
        
          
        
    </div>
</div>


