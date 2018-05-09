<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script id="demoFromu" type="text/template">
 {@each RET_OBJ.albumList as it}
 <tr>
            <td>        
             !{it.albumId} 
           </td>
           <td>
             !{it.albumName}
           </td>
           <td>
             !{it.description}
           </td>       
 </tr>
 {@/each}
</script>
