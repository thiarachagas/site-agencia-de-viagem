using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DreamTravel.Models
{
    [Table("promocao")]
    public class Promocao
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Column("id")]
        public int Id { get; set; }

        [Column("nome")]
        public string Nome { get; set; }

        [DataType(DataType.Date)]
        [Column("data_inicio")]
        public DateTime DataInicio { get; set; }

        [DataType(DataType.Date)]
        [Column("data_termino")]
        public DateTime DataTermino { get; set; }

        [Column("desconto")]
        public double Desconto { get; set; }

        [Column("fk_destino_id")]
        public int DestinoId { get; set; }
        public Destino Destino { get; set; }
    }
}
