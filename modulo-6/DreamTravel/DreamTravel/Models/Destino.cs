using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DreamTravel.Models
{
    [Table("destino")]
    public class Destino
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Column("id")]
        public int Id { get; set; }

        [Column("nome")]
        public string Nome { get; set; }

        [Column("descricao")]
        public string Descricao { get; set; }

        [Column("localizacao")]
        public string Localizacao { get; set; }

        [Column("preco_medio")]
        public double PrecoMedio { get; set; }

        [Column("imagem")]
        public byte[] Imagem { get; set; }

        [Column("internacional")]
        public bool Internacional { get; set; }
    }
}
