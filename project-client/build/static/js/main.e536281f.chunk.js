(this["webpackJsonpproject-client"]=this["webpackJsonpproject-client"]||[]).push([[0],{43:function(e,t,n){},71:function(e,t,n){"use strict";n.r(t);var r=n(1),c=n(0),a=n(13),s=n.n(a),i=(n(43),n(11)),o=n.n(i),u=n(14),j=n(6),l="SET_USERS",d="SET_PAGE",b="SET_CURRENT_USER",O=function(e){return{type:l,payload:{users:e}}},x=function(e){return{type:d,payload:{page:e}}},f=function(e){return{type:b,payload:{currentUser:e}}},m=n(36),h=n.n(m),p={getUsersByPage:function(){var e=Object(u.a)(o.a.mark((function e(t){var n;return o.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,h.a.get("http://ec2-54-237-51-236.compute-1.amazonaws.com:8080/project-server_war"+"/users/page/".concat(t));case 2:return n=e.sent,e.abrupt("return",n.data);case 4:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()},v=n(75),g=n(73),w=n(72),y=n(76),N=function(){var e=Object(j.c)((function(e){return e.page.page})),t=Object(j.b)(),n=function(t){return e>=6?e+(t+1-6):e+(t+1-e)};return Object(r.jsx)("div",{className:"d-flex",children:Object(r.jsxs)(y.a,{className:"mx-auto",children:[Object(r.jsx)(y.a.First,{onClick:function(){return t(x(1))}}),Object(r.jsx)(y.a.Prev,{disabled:1===e,onClick:function(){return t(x(e-1))}}),Array(e<6?e-1:5).fill(0).map((function(e,c){return Object(r.jsx)(y.a.Item,{onClick:function(){return t(x(n(c)))},children:n(c)},c)})),Object(r.jsx)(y.a.Item,{active:!0,children:e}),Array(e>200?205-e:5).fill(0).map((function(n,c){return Object(r.jsx)(y.a.Item,{onClick:function(){return t(x(e+c+1))},children:e+c+1},c)})),Object(r.jsx)(y.a.Next,{disabled:205===e,onClick:function(){return t(x(e+1))}}),Object(r.jsx)(y.a.Last,{onClick:function(){return t(x(205))}})]})})},k=function(){var e=Object(j.b)(),t=Object(j.c)((function(e){return e.page.page})),n=Object(j.c)((function(e){return e.users.users}));return Object(c.useEffect)((function(){(function(){var n=Object(u.a)(o.a.mark((function n(){return o.a.wrap((function(n){for(;;)switch(n.prev=n.next){case 0:return n.t0=e,n.t1=O,n.next=4,p.getUsersByPage(t);case 4:n.t2=n.sent,n.t3=(0,n.t1)(n.t2),(0,n.t0)(n.t3);case 7:case"end":return n.stop()}}),n)})));return function(){return n.apply(this,arguments)}})()()}),[e,t]),Object(r.jsxs)(r.Fragment,{children:[Object(r.jsx)(v.a,{className:"mx-auto w-75 mt-5 mb-3",children:n.map((function(t,n){return Object(r.jsx)(v.a.Item,{children:Object(r.jsxs)(g.a,{style:{border:"none"},children:[Object(r.jsx)(g.a.Title,{children:Object(r.jsx)(w.a,{variant:"link",onClick:function(){e(f(t))},children:t.name})}),Object(r.jsx)(g.a.Body,{className:"mt-0 pt-0",children:t.text}),Object(r.jsx)(g.a.Footer,{className:"text-muted",children:Object(r.jsxs)("div",{className:"d-flex flex-row",children:[Object(r.jsx)("div",{children:new Date(t.tweetCreated).toLocaleString()}),Object(r.jsx)("div",{className:"ml-auto",children:t.tweetLocation})]})})]})},n)}))}),Object(r.jsx)(N,{})]})},U=(n(68),{users:[]}),C={page:1},E="NONE",S={currentUser:E},B=n(74),T=function(){var e=Object(j.b)();return Object(r.jsx)(B.a,{children:Object(r.jsx)(B.a.Item,{className:"m-3",children:Object(r.jsx)(B.a.Link,{onClick:function(){e(f(E))},children:"Back to Timeline"})})})},F=function(){var e=Object(j.c)((function(e){return e.currentUser.currentUser}));return Object(r.jsxs)(r.Fragment,{children:[Object(r.jsx)(T,{}),Object(r.jsxs)(g.a,{className:"mx-auto w-75",children:[Object(r.jsx)(g.a.Title,{className:"text-center mb-3",children:e.name}),Object(r.jsx)(g.a.Subtitle,{className:"text-center mb-3",children:e.description}),Object(r.jsx)(g.a.Body,{className:"text-center mb-3",children:e.text}),Object(r.jsx)(g.a.Footer,{className:"text-muted",children:Object(r.jsxs)("div",{className:"d-flex flex-row",children:[Object(r.jsx)("div",{children:new Date(e.tweetCreated).toLocaleString()}),Object(r.jsx)("div",{className:"ml-auto",children:e.tweetLocation})]})})]})]})},I=function(){var e=Object(j.c)((function(e){return e.currentUser.currentUser}));return Object(r.jsx)(r.Fragment,{children:e===E?Object(r.jsx)(k,{}):Object(r.jsx)(F,{})})};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));var L=n(12),_=n(37),P=n(9),R=Object(L.c)({users:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:U,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case l:return Object(P.a)(Object(P.a)({},e),{},{users:t.payload.users});default:return e}},page:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:C,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case d:return Object(P.a)(Object(P.a)({},e),{},{page:t.payload.page});default:return e}},currentUser:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:S,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case b:return Object(P.a)(Object(P.a)({},e),{},{currentUser:t.payload.currentUser});default:return e}}}),A=Object(L.d)(R,Object(L.a)(_.a));s.a.render(Object(r.jsx)(j.a,{store:A,children:Object(r.jsx)(I,{})}),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))}},[[71,1,2]]]);
//# sourceMappingURL=main.e536281f.chunk.js.map