import kotlin.random.Random

fun main() {
    ex01()
}

//  Verificação de Números Primos
fun ex01() {
    print("Insira um número: ")
    val num = readln().toInt()

    if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
        println("O número $num, NÃO é um Número Primo!")
    }
    else {
        println("O número $num, É um Número Primo!")
    }
}

// Contagem de Palavras em um Texto
fun ex02() {
    println("Insira um texto: ")
    val texto = readLine()

    if (texto != null) {
        val palavras = texto.split(" ")

        val numPalavras = palavras.size

        println("O texto possui $numPalavras palavras.")
    } else {
        println("Nenhum texto foi inserido.")
    }
}

// Gerenciamento de Notas dos Alunos
fun ex03() {
    class Aluno(val nome: String, val notas: DoubleArray) {
        fun calcularMedia(): Double {
            return notas.average()
        }
        fun foiAprovado(): Boolean {
            return calcularMedia() >= 70
        }
    }
    fun media() {
        val alunos = ArrayList<Aluno>()

        for (i in 1..5) {
            println("Digite o NOME do aluno $i: ")
            val nome = readLine()!!

            val notas = DoubleArray(4)
            for (j in notas.indices) {
                println("Digite a NOTA ${j + 1} de $nome: ")
                notas[j] = readLine()!!.toDouble()
            }
            val aluno = Aluno(nome, notas)
            alunos.add(aluno)
        }
        for (aluno in alunos) {
            val media = aluno.calcularMedia()
            val status = if (aluno.foiAprovado()) "Aprovado" else "Reprovado"
            println("${aluno.nome} - Média: %.2f - $status".format(media))
        }
    }
    media()
}

// Ordenação de Nomes de Alunos
fun ex04() {
        val alunos = Array(10) { "" }

        for (i in alunos.indices) {
            println("Digite o nome do aluno ${i + 1}:")
            alunos[i] = readLine()!!
        }
        alunos.sort()

        println("\nLista de alunos em ordem alfabética:")
        for (aluno in alunos) {
            println(aluno)
        }
    }

// Simulação de Jogo de Dados
fun ex05() {
    println("Quantas vezes você deseja lançar os dados?")
    val numLances = readLine()!!.toInt()

    for (i in 1..numLances) {
        val dado1 = Random.nextInt(1, 7)
        val dado2 = Random.nextInt(1, 7)
        val soma = dado1 + dado2

        println("Lançamento $i: Dado 1 = $dado1, Dado 2 = $dado2, Soma = $soma")
    }
}

// Análise de Dados Meteorológicos
fun ex06() {
    val temperaturas = DoubleArray(30)

    for (i in 0 until 30) {
        println("Digite a temperatura do dia ${i + 1}:")
        temperaturas[i] = readLine()!!.toDouble()
    }

    var somaTemperaturas = 0.0
    for (temp in temperaturas) {
        somaTemperaturas += temp
    }
    val media = somaTemperaturas / 30

    var tempMaxima = temperaturas[0]
    var tempMinima = temperaturas[0]
    var diaMaxima = 1
    var diaMinima = 1

    for (i in 1 until 30) {
        if (temperaturas[i] > tempMaxima) {
            tempMaxima = temperaturas[i]
            diaMaxima = i + 1
        }
        if (temperaturas[i] < tempMinima) {
            tempMinima = temperaturas[i]
            diaMinima = i + 1
        }
    }

    println("\nTemperatura Média: %.2f".format(media))
    println("Temperatura Máxima: %.2f (ocorreu no dia $diaMaxima)".format(tempMaxima))
    println("Temperatura Mínima: %.2f (ocorreu no dia $diaMinima)".format(tempMinima))
}

// Sistema de Reserva de Passagens Aéreas
fun ex07() {
    class Voo(val numeroDoVoo: String, assentos: Int) {
        private val assentosDisponiveis = IntArray(assentos) { 0 }

        fun reservarAssento(assento: Int): Boolean {
            if (assento in assentosDisponiveis.indices) {
                return if (assentosDisponiveis[assento] == 0) {
                    assentosDisponiveis[assento] = 1
                    true
                } else {
                    false
                }
            } else {
                println("O assento inválido.")
                false
            }
            return TODO("Provide the return value")
        }

        fun verificarAssento(assento: Int): Boolean {
            return if (assento in assentosDisponiveis.indices) {
                assentosDisponiveis[assento] == 0
            } else {
                println("Número do assento inválido.")
                false
            }
        }
    }

    fun reserva() {
        val voo = Voo("1234", 10)

        while (true) {
            println("Digite o número do assento que deseja verificar/reservar (ou -1 para sair):")
            val numeroAssento = readLine()!!.toInt()

            if (numeroAssento == -1) {
                break
            }

            if (voo.verificarAssento(numeroAssento)) {
                println("O assento $numeroAssento está disponível. Deseja reservar? (sim/não)")
                val resposta = readLine()!!

                if (resposta.equals("sim", ignoreCase = true)) {
                    if (voo.reservarAssento(numeroAssento)) {
                        println("Assento $numeroAssento reservado com sucesso!")
                    } else {
                        println("O assento $numeroAssento já estava reservado.")
                    }
                } else {
                    println("Reserva cancelada.")
                }
            } else {
                println("O assento $numeroAssento não está disponível.")
            }
        }
    }
    reserva()
}

// Sistema de Gestão de Estoque com Reposição Automática
fun ex08() {
    class Produto(
        val nome: String,
        var quantidade: Int,
        val nivelMinimo: Int,
        val nivelMaximo: Int
    ) {
        fun reporEstoque() {
            if (quantidade < nivelMinimo) {
                quantidade = nivelMaximo
                println("Estoque do produto $nome reabastecido para o nível máximo de $nivelMaximo.")
            }
        }
    }

    fun cadastro() {
        val produtos = mutableListOf<Produto>()

        for (i in 1..5) {
            println("Digite o nome do produto $i:")
            val nome = readLine()!!

            println("Digite a quantidade do produto $nome:")
            val quantidade = readLine()!!.toInt()

            println("Digite o nível mínimo para o produto $nome:")
            val nivelMinimo = readLine()!!.toInt()

            println("Digite o nível máximo para o produto $nome:")
            val nivelMaximo = readLine()!!.toInt()

            val produto = Produto(nome, quantidade, nivelMinimo, nivelMaximo)
            produtos.add(produto)
        }

        for (produto in produtos) {
            println("\nProduto: ${produto.nome}")
            println("Quantidade disponível: ${produto.quantidade}")

            if (produto.quantidade < produto.nivelMinimo) {
                produto.reporEstoque()
            } else {
                println("A quantidade está acima do nível mínimo.")
            }
        }
    }
    cadastro()
}

