package uz.salvadore.datagrid.library;

public interface IDataGridMapper<I, O> {

  O fromJpaEntity(I input);

}
