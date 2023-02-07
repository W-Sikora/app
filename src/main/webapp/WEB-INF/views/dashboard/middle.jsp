<%@include file="../imports/jsp-imports.jsp" %>

<div class="columns is-vcentered has-text-centered">

    <div class="column mr-6">
        <div class="box">
            <p class="title is-4">
                <fmt:message key="expenditures.in.groups"/>
            </p>

            <div class="columns is-multiline">
                <div class="column is-full">
                    <canvas id="doughnutChart" class="doughnut-chart"></canvas>
                </div>
            </div>
        </div>
    </div>

    <div class="column">
        <div class="box">
            <p class="title is-4">
                <fmt:message key="unnecessary.expenses"/>
            </p>

            <div class="columns is-multiline has-text-left">
                <div class="column is-full">
                    <%@ include file="unnecessary.jsp"%>
                </div>
            </div>
        </div>
    </div>
</div>
