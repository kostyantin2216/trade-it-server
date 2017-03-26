# Description
This is a sample of my work and was made as a server side for <a href="https://github.com/kostyantin2216/trade-it-app">Trade It App</a>.
The project is split into 3 modules and all modules are built and managed with Maven.

- infrastructure is the main module which is made up of Spring and Hibernate and has all the important general code for trade it signals as a whole(eg. Pojos, DAOs, Controllers...) and is included in all other modules.
- rest is the next most important module which is made up of Spring and Jersey for a RESTful Web Service.
- web is the final module which is made up of Spring, JSF and Primefaces, it is not important in anyway and was created for anything that needed a web U.I. but in the end was only used for practice and never saw the day of light on any production level application server.

The server was hosted using Linode.com on CentOS 7 with Wildfly, MySQL and Apache.
