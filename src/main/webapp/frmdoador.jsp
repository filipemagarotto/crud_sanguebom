<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.projeto_sanguebom.model.Doador"%>
<%@page import="br.com.projeto_sanguebom.jdbc.doadorDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Editar Doador</title>
        <!--TODO TAILWIND CSS -->
        <script src="https://cdn.tailwindcss.com"></script>
        <!--TODO TAILWIND JS -->
        <link rel="stylesheet" href="style.css">
    </head>
	<body>
	<!--? MODA CADASTRAR DOADOR  -->
	<% 
	Doador doador = (Doador)request.getAttribute("doador");
	%>
        <div class="container-modal" id="container-modal">
                <div class="center z-50 w-full h-full  bg-[#00000060]">
                    <div class="max-w-4xl mx-auto my-10 bg-white p-5 rounded-md shadow-sm">
                        
                        <div class="text-center">
                            <h1 class="my-5 text-3xl font-bold text-gray-700 dark:text-gray-200">Editar <%=doador.getNome()%></h1>
                        </div>
                        <div class="m-7 ">
                            <form class="grid grid-cols-2" action="doadorcontroller.do" method="POST" id="form">

                                <input type="hidden" name="apikey" value="YOUR_ACCESS_KEY_HERE">
                                <input type="hidden" name="subject" value="New Submission from Web3Forms">
                                <input type="checkbox" name="botcheck" id="" style="display: none;">

								<div class="mb-6 mx-5">
                                    <label for="id" class="block mb-2 text-sm text-gray-600 dark:text-gray-400">Id</label>
                                    <input type="number" name="idCadastro" readonly id="idCadastro" value="<%=doador.getId()%>" placeholder="Filipe Magarotto" class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-zinc-800 dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                                </div>
                                <div class="mb-6 mx-5">
                                    <label for="name" class="block mb-2 text-sm text-gray-600 dark:text-gray-400">Nome</label>
                                    <input type="text" name="nomeCadastro" id="nomeCadastro" value="<%=doador.getNome()%>" placeholder="Filipe Magarotto" required class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-zinc-800 dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                                </div>
                                <div class="mb-6 mx-5">
                                    <label for="cpf" class="block mb-2 text-sm text-gray-600 dark:text-gray-400">CPF</label>
                                    <input type="number" maxlength="11" value="<%=doador.getCpf()%>" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" name="cpfCadastro" id="cpfCadastro" placeholder="12345678910" required class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-zinc-800 dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                                </div>
                                <div class="mb-6 mx-5">

                                    <label for="email" class="text-sm text-gray-600 dark:text-gray-400">Email</label>
                                    <input type="email" name="emailCadastro" id="emailCadastro" value="<%=doador.getEmail()%>" placeholder="exemplo@exemplo.com" required class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-zinc-800 dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                                </div>

                                <div class="mb-6 mx-5">

                                    <label for="telefone" class="text-sm text-gray-600 dark:text-gray-400">Telefone</label>
                                    <input type="number" name="telefoneCadastro" id="telefoneCadastro" value="<%=doador.getTelefone()%>" placeholder="11912345678" required class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-zinc-800 dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                                </div>

                                <div class="mb-6 mx-5">

                                    <label for="nascimento" class="text-sm text-gray-600 dark:text-gray-400">Data de nascimento</label>
                                    <input type="date" name="nascimentoCadastro" id="nascimentoCadastro" value="<%=doador.getDataNascimento()%>" placeholder="01/01/1981" required class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-zinc-800 dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                                </div>


                                <div class="mb-6 mx-5">
                                    <label for="uf" class="text-sm text-gray-600 dark:text-gray-400">UF</label>
                                    <input type="text" maxlength="2" name="ufCadastro" id="ufCadastro" placeholder="SP" value="<%=doador.getUf()%>"required class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-zinc-800 dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                                </div>

                                <div class="mb-6 mx-5">

                                    <label for="cidade" class="text-sm text-gray-600 dark:text-gray-400">Cidade</label>
                                    <input type="text" name="cidadeCadastro" id="cidadeCadastro" placeholder="Jundiaí" value="<%=doador.getCidade()%>" required class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-zinc-800 dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                                </div>

                                <div class="mb-6 mx-5">

                                    <label for="sanguineo" class="text-sm text-gray-600 dark:text-gray-400">Tipo sanguineo</label>
                                    <input type="text" name="tipoSanguineoCadastro" id="tipoSanguineoCadastro" placeholder="A+" value="<%=doador.getTipo_sanguineo()%>" required class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-zinc-800 dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                                </div>

                                <div class="mb-6 col-start-2 grid justify-self-end mt-10 w-[40%]">
                                    <button type="submit" class=" w-full px-3 py-4 text-white bg-red-500 rounded-md hover:bg-red-600 focus:outline-none">Editar</button>
                                </div>
                                <p class="text-base text-center text-gray-400" id="result">
                                </p>
                            </form>
                        </div>
                    </div>

        </div> <!--? FIM MODA CADASTRAR DOADOR  -->
	<!--? NAV BAR  -->
        <nav class="bg-red-500 border-gray-200 px-2 sm:px-4 py-4 
            dark:bg-gray-800">
            <div class="container flex flex-wrap justify-between items-center
                mx-auto">
                <a href="/index.html" class="flex items-center">
                    <span class="self-center text-2xl text-white font-semibold
                        whitespace-nowrap ">SANGUE BOM</span> 
                </a>
                <div class="hidden w-full md:block md:w-auto " id="mobile-menu">
                    <ul class="flex flex-col mt-4 md:flex-row md:space-x-8
                        md:mt-0 md:text-sm md:font-medium">
                        <li>
                            
                        </li>
                    </ul>
                </div>
            </div>
        </nav><!--? FIN NAVBAR -->
        
        <script src="https://unpkg.com/tailwindcss-jit-cdn"></script>
        <script src="main.js"></script>
	</body>
</html>