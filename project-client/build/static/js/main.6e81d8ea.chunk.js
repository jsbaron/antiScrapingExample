(this["webpackJsonpproject-client"]=this["webpackJsonpproject-client"]||[]).push([[0],{50:function(e,t,n){},79:function(e,t,n){"use strict";n.r(t);var r=n(2),c=n(0),a=n(11),s=n.n(a),i=(n(50),n(14)),o=n.n(i),u=n(18),j=n(6),l="SET_USERS",d="SET_PAGE",b="SET_CURRENT_USER",O=function(e){return{type:l,payload:{users:e}}},x=function(e){return{type:d,payload:{page:e}}},m=function(e){return{type:b,payload:{currentUser:e}}},h=n(41),f=n.n(h),p={users:[]},v={page:1},g="NONE",w={currentUser:g},y="ENFORCED",N={getUsersByPage:function(){var e=Object(u.a)(o.a.mark((function e(t){var n;return o.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,f.a.get("http://ec2-54-237-51-236.compute-1.amazonaws.com:8080/project_archive"+"/users/page/".concat(t));case 3:return n=e.sent,e.abrupt("return",n.data);case 7:if(e.prev=7,e.t0=e.catch(0),!e.t0.response||429!==e.t0.response.status){e.next=13;break}return e.abrupt("return",y);case 13:throw new Error(e.t0);case 14:case"end":return e.stop()}}),e,null,[[0,7]])})));return function(t){return e.apply(this,arguments)}}()},k=n(82),U=n(85),E=n(84),C=n(81),S=n(86),F=function(){var e=Object(j.c)((function(e){return e.page.page})),t=Object(j.b)(),n=function(t){return e>=6?e+(t+1-6):e+(t+1-e)};return Object(r.jsx)("div",{className:"d-flex",children:Object(r.jsxs)(S.a,{className:"mx-auto",children:[Object(r.jsx)(S.a.First,{onClick:function(){return t(x(1))}}),Object(r.jsx)(S.a.Prev,{disabled:1===e,onClick:function(){return t(x(e-1))}}),Array(e<6?e-1:5).fill(0).map((function(e,c){return Object(r.jsx)(S.a.Item,{onClick:function(){return t(x(n(c)))},children:n(c)},c)})),Object(r.jsx)(S.a.Item,{active:!0,children:e}),Array(e>200?205-e:5).fill(0).map((function(n,c){return Object(r.jsx)(S.a.Item,{onClick:function(){return t(x(e+c+1))},children:e+c+1},c)})),Object(r.jsx)(S.a.Next,{disabled:205===e,onClick:function(){return t(x(e+1))}}),Object(r.jsx)(S.a.Last,{onClick:function(){return t(x(205))}})]})})},B=function(){var e=Object(j.b)(),t=Object(j.c)((function(e){return e.page.page})),n=Object(j.c)((function(e){return e.users.users}));return Object(c.useEffect)((function(){(function(){var n=Object(u.a)(o.a.mark((function n(){return o.a.wrap((function(n){for(;;)switch(n.prev=n.next){case 0:return n.t0=e,n.t1=O,n.next=4,N.getUsersByPage(t);case 4:n.t2=n.sent,n.t3=(0,n.t1)(n.t2),(0,n.t0)(n.t3);case 7:case"end":return n.stop()}}),n)})));return function(){return n.apply(this,arguments)}})()()}),[e,t]),Object(r.jsx)(r.Fragment,{children:n===y?Object(r.jsx)(k.a,{variant:"danger",className:"ml-auto mr-auto mt-5",children:Object(r.jsx)("h3",{children:"You're making too many requests!"})}):Object(r.jsxs)(r.Fragment,{children:[Object(r.jsx)(U.a,{className:"mx-auto w-75 mt-5 mb-3",children:n.map((function(t,n){return Object(r.jsx)(U.a.Item,{children:Object(r.jsxs)(E.a,{style:{border:"none"},children:[Object(r.jsx)(E.a.Title,{children:Object(r.jsx)(C.a,{variant:"link",onClick:function(){e(m(t))},children:t.name})}),Object(r.jsx)(E.a.Body,{className:"mt-0 pt-0",children:t.text}),Object(r.jsx)(E.a.Footer,{className:"text-muted",children:Object(r.jsxs)("div",{className:"d-flex flex-row",children:[Object(r.jsx)("div",{children:new Date(t.tweetCreated).toLocaleString()}),Object(r.jsx)("div",{className:"ml-auto",children:t.tweetLocation})]})})]})},n)}))}),Object(r.jsx)(F,{})]})})},T=(n(76),n(83)),I=function(){var e=Object(j.b)();return Object(r.jsx)(T.a,{children:Object(r.jsx)(T.a.Item,{className:"m-3",children:Object(r.jsx)(T.a.Link,{onClick:function(){e(m(g))},children:"Back to Timeline"})})})},L=function(){var e=Object(j.c)((function(e){return e.currentUser.currentUser}));return Object(r.jsxs)(r.Fragment,{children:[Object(r.jsx)(I,{}),Object(r.jsxs)(E.a,{className:"mx-auto w-75",children:[Object(r.jsx)(E.a.Title,{className:"text-center mb-3",children:e.name}),Object(r.jsx)(E.a.Subtitle,{className:"text-center mb-3",children:e.description}),Object(r.jsx)(E.a.Body,{className:"text-center mb-3",children:e.text}),Object(r.jsx)(E.a.Footer,{className:"text-muted",children:Object(r.jsxs)("div",{className:"d-flex flex-row",children:[Object(r.jsx)("div",{children:new Date(e.tweetCreated).toLocaleString()}),Object(r.jsx)("div",{className:"ml-auto",children:e.tweetLocation})]})})]})]})},R=function(){var e=Object(j.c)((function(e){return e.currentUser.currentUser}));return Object(r.jsx)(r.Fragment,{children:e===g?Object(r.jsx)(B,{}):Object(r.jsx)(L,{})})};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));var _=n(15),P=n(44),A=n(10),D=Object(_.c)({users:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:p,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case l:return Object(A.a)(Object(A.a)({},e),{},{users:t.payload.users});default:return e}},page:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:v,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case d:return Object(A.a)(Object(A.a)({},e),{},{page:t.payload.page});default:return e}},currentUser:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:w,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case b:return Object(A.a)(Object(A.a)({},e),{},{currentUser:t.payload.currentUser});default:return e}}}),J=Object(_.d)(D,Object(_.a)(P.a));s.a.render(Object(r.jsx)(j.a,{store:J,children:Object(r.jsx)(R,{})}),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))}},[[79,1,2]]]);
//# sourceMappingURL=main.6e81d8ea.chunk.js.map