var tipoSanguineo;
var tipoUF;
var cidade;
var cpf;

var tiposUF = [
    'AC','AL','AP','AM','BA','CE','DF','ES','GO','MA',
    'MT','MS','MG','PA','PB','PR','PE','PI','RJ','RN','RS','RO',
    'RR','SC','SP','SE','TO'
]

function handleTipoSanguineo(valor) {
    tipoSanguineo = valor;

    document.getElementById('selectTipoSanguineo').value = tipoSanguineo
    document.getElementById('show-tipoSanguineo').style.display = 'none';
}

var str = ''
tiposUF.forEach(function(UF) {
    str += '<div class="cursor-pointer group"><a class="block p-2 border-transparent border-l-4 group-hover:border-blue-600 group-hover:bg-gray-100" onclick="handleTipoUFSelecionado(\''+UF+'\')">'+UF+'</a></div>';
}); 
document.getElementById("show-tipoUF").innerHTML = str;

function handleShowTipoSanguineo() {
    if(document.getElementById('show-tipoSanguineo').style.display == 'none') document.getElementById('show-tipoSanguineo').style.display = 'block';
    else document.getElementById('show-tipoSanguineo').style.display = 'none';
}

function handleShowTipoUF() {
    if(document.getElementById('show-tipoUF').style.display == 'none') document.getElementById('show-tipoUF').style.display = 'block';
    else document.getElementById('show-tipoUF').style.display = 'none';

}

function handleTipoUFSelecionado(uf) {
    tipoUF = uf

    document.getElementById('selectTipoUF').value = tipoUF;
    document.getElementById('show-tipoUF').style.display = 'none';
}

function handleCidade() {
    cidade = document.getElementById('input-cidade').value
    console.log(cidade)
}

function handleBuscarByCPF() {
    cpf = document.getElementById('input-cpf').value
    
	var xhttp = null;
    if (window.XMLHttpRequest) {
        //code for modern browsers
        xhttp = new XMLHttpRequest();
    } else {
        // code for old IE browsers
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    xhttp.open("POST", "/projeto_sanguebom/doadorcontroller.do", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("acao=filtarcpf&cpf="+cpf); // Exemplo de passagem de parametros.
    console.log(cpf)
    
}
function handleModalCadastrar() {
    if(document.getElementById('container-modal').style.display == 'none') document.getElementById('container-modal').style.display = 'block'
    else document.getElementById('container-modal').style.display = 'none';
}
