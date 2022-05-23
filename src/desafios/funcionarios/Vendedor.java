package desafios.funcionarios;

public class Vendedor extends Funcionario {
  private double comissao;
  private long numeroVendas;

  public Vendedor(String nome, long cpf, double comissao, long numeroVendas) {
    super(nome, cpf);
    this.comissao = comissao;
    this.numeroVendas = numeroVendas;
  }

  @Override
  public double calcularSalario() {
    return super.SALARIO_MINIMO + (this.comissao * this.numeroVendas);
  }

  public double getComissao() {
    return comissao;
  }

  public void setComissao(double comissao) {
    this.comissao = comissao;
  }

  public long getNumeroVendas() {
    return numeroVendas;
  }

  public void setNumeroVendas(long numeroVendas) {
    this.numeroVendas = numeroVendas;
  }
}
