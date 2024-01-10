
export const ImgBase64 = (props: { src: string, alt: string, className: string }) => {

    const { src, alt, className } = props;
    return <img className={className} src={`data:image/jpeg;base64, ${src}`} alt={alt} />
};