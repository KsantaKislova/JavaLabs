<#macro shots>
    <#list tickets as ticket>
        <div style="margin-left: 10%; padding:0.5rem; padding-bottom:0.2rem; margin-bottom: 1rem; width: 70%; border-style: solid; border-radius: 0.5rem; border-color: darkcyan; background-color: cornflowerblue;">
            <span style="margin-bottom:1rem;float:left; color: hotpink;">${ticket.name}</span>
            <span style="float:right; color: chartreuse; font-style: oblique;">${ticket.date}</span>
            <span style="margin-right: -4.5rem;margin-top:1.3rem;float:right; color: darkorange; font-style: oblique;">${ticket.flightClass}</span>
            <br/>
            <span style="word-break: break-all; color: bisque; font-style: italic;">${ticket.passportNumber}</span>
            <form method="post" action="/Home/delete">
                <input type="hidden" name="id" value="${ticket.id}">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button style="float:right; margin-left: 2rem; color: tomato" type="submit" >delete</button>
            </form>
        </div>
    <#else>
        <br/>
        You don't have any tickets!
    </#list>
</#macro>
