	<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Configuration</title>
        
        <style>
             {padding:0; margin:0;}

            html {
                padding:15px 15px 0;
                font-family:sans-serif;
                font-size:14px;
            }

            p, h3 {
                margin-bottom:15px;
            }

            div {
                padding:10px;
                width:600px;
                background:#fff;
            }

            .tabss li {
                list-style:none;
                display:inline;
            }

            .tabss a {
                padding:5px 10px;
                display:inline-block;
                background:#666;
                color:#fff;
                text-decoration:none;
            }

            .tabss li.active a{
                background:#f0f;
                color:#00;
            }
           
            .tab_content {
                display: none;
            }
        </style>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js">
         </script>
       
        <script>

         // Wait until the DOM has loaded before querying the document
         $(document).ready(function(){

            //Active tab selection after page load       
            $('#tabs').each(function(){
           
            // For each set of tabs, we want to keep track of
            // which tab is active and it's associated content
            var $active, $content, $links = $(this).find('a');
           
            // If the location.hash matches one of the links, use that as the active tab.
            // If no match is found, use the first link as the initial active tab.
            $active = $($links.filter('[href="'+location.hash+'"]')[0]
                      || $links[0]);
            
            $active.parent().addClass('active');
           
            $content = $($active.attr('href'));
            $content.show();
        });
       
       
         $("#tabs li").click(function() {
                
             // First remove class "active" from currently active tab
             $("#tabs li").removeClass('active');
        
             // Now add class "active" to the selected/clicked tab
             $(this).addClass("active");
                
             // Hide all tab content
             $(".tab_content").hide();

             // Here we get the href value of the selected tab
             var selected_tab = $(this).find("a").attr("href");      

             var starting = selected_tab.indexOf("#");
             var sub = selected_tab.substring(starting);
               
             //write active tab into cookie
                
             //$(sub).show();
                 $(sub).fadeIn();
             // At the end, we add return false so that the click on the
            // link is not executed
             return false;
          });
        });

       </script>

    </head>
    <body>
        <ul id='tabs' class="tabss">
            <li><a href='#tab1'>Asset Allocation</a></li>
            <li><a href='#tab2'>SpendingRates</a></li>
            <li><a href='#tab3'>Divident Tax Rates</a></li>
            <li><a href='#tab4'>Income Tax Rate</a></li>
            <li><a href='#tab5'>Capital Gains Tax Rates</a></li>
            <li><a href='#tab6'>Inflation</a></li>
            <li><a href='#tab7'>Equity Market Returns</a></li>
            <li><a href='#tab8'>Tax Formula</a></li>
        </ul>
        <div id='tab1' class="tab_content" >
          <display:table>
            Asset Allocation           
          </display:table>
        </div>
        
        <div id='tab2' class="tab_content">
            <display:table>
            Spending Rates
            </display:table>
        </div>
        <div id='tab3' class="tab_content">
            <display:table>
            Divident Tax Rates
            </display:table>
        </div>
        <div id='tab4' class="tab_content">
            <display:table>
            Income Tax Rate
            </display:table>
        </div>
        <div id='tab5' class="tab_content">
            <display:table>
            Capital Gains Tax Rates
            </display:table>
        </div>
        <div id='tab6' class="tab_content">
            <display:table>
            Inflation
            </display:table>
        </div>
        <div id='tab7' class="tab_content">
            <display:table>
            Equity Market Returns
            </display:table>
        </div>
        <div id='tab8' class="tab_content">
            <display:table>
            Tax Formula
            </display:table>
        </div>
        
        
    </body>
</html>
